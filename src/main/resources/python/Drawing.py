from dxfwrite import DXFEngine as dxf
import sys
from time import gmtime, strftime

savingdir = sys.argv[2] + "/" + sys.argv[3] + "_SODS" +strftime("_%Y_%m_%d_%H_%M_%S", gmtime()) + ".dxf"

drawing = dxf.drawing(savingdir)
file = open(sys.argv[1] ,"r") #opens file with name of "test.txt"
#file = open("E:\\we.txt","r")
myList = []


golbalX = 0
globalY = 0
shift = 2000

#drawing bars along length 
def barsAlongLength(noOfbars,disp, pointXaxis , pointYaxis):
    for i in range(noOfbars):
        circle = dxf.circle(barsDiameter/2, (pointXaxis,pointYaxis))
        circle['layer'] = 'points'
        circle['color'] = 7
        circle['center'] = (pointXaxis,pointYaxis) # int or float
        circle['radius'] = barsDiameter/2
        drawing.add(circle)
        pointXaxis=disp+pointXaxis
        
#drawing bars along width 
def barsAlongWidth (noOfbars , disp  , side , startPointXaxis , pointYaxis):
    pointXaxis = startPointXaxis
    for x in range(noOfbars-2):
        for i in range(2):
            circle = dxf.circle(barsDiameter/2, (pointXaxis,pointYaxis))
            circle['layer'] = 'points'
            circle['color'] = 7
            circle['center'] = (pointXaxis,pointYaxis) # int or float
            circle['radius'] = barsDiameter/2
            drawing.add(circle) 
            pointXaxis = side+pointXaxis
        
        pointXaxis = startPointXaxis
        pointYaxis = disp+pointYaxis

#drawing trapezodial 
def trapezoidal(p1=(0,0),p2=(0,0),p3=(0,0),p4=(0,0)):
    line = dxf.line(p1, p2)
    line['layer'] = 'walls'
    line['color'] = 7
    drawing.add(line)

    line2 = dxf.line(p2, p4)
    line2['layer'] = 'walls'
    line2['color'] = 7
    drawing.add(line2)

    line3 = dxf.line(p3, p4)
    line3['layer'] = 'walls'
    line3['color'] = 7
    drawing.add(line3)

    line4 = dxf.line(p1, p3)
    line4['layer'] = 'walls'
    line4['color'] = 7
    drawing.add(line4)

noOfFloor = int(float(file.readline()))  

for f in range(noOfFloor):
    noOfColumn = int(float(file.readline()))
    
    for c in range(noOfColumn):
        #just initial values 
        width=0
        length=0
        mainStirrupWidth=0
        mainStirrupLength=0
        barsDiameter=0
        noOfBarsAlongWidth=0
        noOfBarsAlongLength=0

        noOfSingleStirrupsAlongLength=0
        noOfRecStirrupsAlongLength=0
        noOfSingleStirrupsAlongWidth=0
        noOfRecStirrupsAlongWidth=0

        SingleStirrupOffesetsAlongLength=[]
        RecStirrupOffesetsAlongLength=[]
        RecStrirruplenghts=[]

        SingleStirrupOffesetsAlongWidth=[]
        RecStirrupOffesetsAlongWidth=[]
        RecStrirrupWidths = []
        isTrapExist = 0

        #extracting informtions from file or string send to the script 
        for line in file:
            line = line.strip('\n')
            if line == ',':
                break
            #myList.append(int(line))
            myList = line.split(' ',1)
           
            #	w stands for width of the column as whole 
            if myList[0]=='w':
                width = int(float(myList[1]))
            
            #	l stands for length of the column as whole
            elif myList[0]=='l':
                length = int(float(myList[1]))

            #	msw stands for main stirrups width
            elif myList[0]=='msw':
                mainStirrupWidth= int(float(myList[1]))

            #	msl stands for main stirrups length
            elif myList[0]=='msl':
                mainStirrupLength= int(float(myList[1]))

            #	d stands for diameter of one bar, all bar are equal in diameter
            elif myList[0] == 'd':
                barsDiameter= int(float(myList[1]))

            #	bw stands for number of bars along width 
            elif myList[0]=='bw':
                noOfBarsAlongWidth= int(float(myList[1]))

            #	bl stands for number of bars along length 
            elif myList[0]=='bl':
                noOfBarsAlongLength= int(float(myList[1]))

            #	ssl stands for number of single stirrups along length 
            elif myList[0] == 'ssl':
                noOfSingleStirrupsAlongLength=int(float(myList[1].split()[0]))
                #	Offsets of ssl
                SingleStirrupOffesetsAlongLength= [int (float(x)) for x in myList[1].split()[1:]]

            #	rsl stands for number of rectangular stirrups along length 
            elif myList[0] =='rsl':
                noOfRecStirrupsAlongLength=int(float(myList[1].split()[0]))
                #	Offsets of rsl
                RecStirrupOffesetsAlongLength=[int (float(x)) for x in myList[1].split()[1:]]

            #	ssw stands for number of single stirrups along width 
            elif myList[0]=='ssw':
                noOfSingleStirrupsAlongWidth=int(float(myList[1].split()[0]))
                #	Offsets of ssw
                SingleStirrupOffesetsAlongWidth=[int (float(x)) for x in myList[1].split()[1:]]

            #	rsw stands for number of rectangular stirrups along width
            elif myList[0]=='rsw':
                noOfRecStirrupsAlongWidth=int(float(myList[1].split()[0]))
                #	Offsets of rsw
                RecStirrupOffesetsAlongWidth=[int (float(x)) for x in myList[1].split()[1:]]

            #	rl stands for rectangular stirrups lengths 
            elif myList[0]=='rl':
                RecStrirruplenghts= [int (float(x)) for x in myList[1].split()]

            #	rw stands for rectangular 
            elif myList[0]=='rw':
                RecStrirrupWidths = [int (float(x)) for x in myList[1].split()]
            
            #	t stands for trapezodial stirrups existance in the drawing 
            elif myList[0]=='t':
                isTrapExist = int(float(myList[1]))
        
        concreteCover = (length-mainStirrupLength)/2  #30

        #displacement between two bars along length from perameter to perameter  
        dispXaxis = (mainStirrupLength-(barsDiameter*noOfBarsAlongLength))/(noOfBarsAlongLength-1)  #135

        #displacement between two bars along length from center to center 
        dispXaxisFromCenters = dispXaxis+barsDiameter #155

        #center of bar to be drawen lower y-axis along length  
        firstPoint = concreteCover+(barsDiameter/2)  #40

        #center of bar to be drawen higher y-axis along length  
        secondPoint= width-concreteCover-(barsDiameter/2)  #260

        #displacement between two bars along width from perameter to perameter
        dispYaxis = (mainStirrupWidth-(barsDiameter*noOfBarsAlongWidth))/(noOfBarsAlongWidth-1) #90

        #displacement between two bars along width from center to center
        dispYaxisFromCenters = dispYaxis + barsDiameter #110

        #single stirrup is eqaul to bar diameter used in case of stirrup drawn along length, as single stirrup holds one bar 
        singleStirruplength = barsDiameter

        #single stirrup is eqaul to bar diameter used in case of stirrup drawn along width, as single stirrup holds one bar 
        singleStirrupwidth = barsDiameter

        '''
        #Trap Points
        firstPointTrap = (0,0)
        secondPointTrap = (0,0)
        thirdPointTrap = (0,0)
        fourthPointTrap = (0,0)
        '''

        #Drawing Rigth And Left Trapezoidal, If Exist 
        if (isTrapExist>0):
            #case one number of bars along width is 3, or 4 bars 
            #in this case we eliminate two bars from the drawing 
            if(noOfBarsAlongWidth<5):
                firstPointTrap = (concreteCover + golbalX , (concreteCover + barsDiameter + dispYaxis + globalY) )
                secondPointTrap = ( concreteCover + golbalX , (width - (concreteCover+barsDiameter+dispYaxis)) + globalY)
                thirdPointTrap = ((concreteCover + (2*barsDiameter) + dispXaxis + golbalX) , concreteCover + globalY)
                fourthPointTrap = ((concreteCover + (2*barsDiameter) + dispXaxis + golbalX) , (width-concreteCover) + globalY)
                
                #Left Trapezoidal
                trapezoidal(firstPointTrap,secondPointTrap,thirdPointTrap,fourthPointTrap)

                
                firstPointTrap = ( (length - (concreteCover + (2*barsDiameter) + dispXaxis) + golbalX) , concreteCover + globalY )
                secondPointTrap = ( (length - (concreteCover + (2*barsDiameter) + dispXaxis) + golbalX) , (width - concreteCover) + globalY)
                thirdPointTrap = ( (length - concreteCover) + golbalX , (concreteCover + barsDiameter + dispYaxis) + globalY )
                fourthPointTrap = ((length - concreteCover) + golbalX , (width - (concreteCover+barsDiameter+dispYaxis)) + globalY)
                
                #Right Trapezoidal
                trapezoidal(firstPointTrap,secondPointTrap,thirdPointTrap,fourthPointTrap)

            #second case if number of bars is 5, 6, or 7 
            else:
            
                firstPointTrap = (concreteCover + golbalX , (concreteCover+ (2*barsDiameter) + (2*dispYaxis)) + globalY)
                secondPointTrap = (concreteCover +golbalX , (width - (concreteCover+ (2*barsDiameter) + (2*dispYaxis))) + globalY)
                thirdPointTrap = ((concreteCover + (2*barsDiameter) + dispXaxis + golbalX) , concreteCover + globalY)
                fourthPointTrap = ((concreteCover + (2*barsDiameter) + dispXaxis + golbalX) , (width-concreteCover) + globalY)
                #Left Trapezoidal
                trapezoidal(firstPointTrap,secondPointTrap,thirdPointTrap,fourthPointTrap)

                firstPointTrap = ( (length - (concreteCover + (2*barsDiameter) + dispXaxis) + golbalX) , concreteCover  + globalY)
                secondPointTrap = ( (length - (concreteCover + (2*barsDiameter) + dispXaxis) + golbalX) , (width - concreteCover) + globalY)
                thirdPointTrap = ( (length - concreteCover) + golbalX , (concreteCover+ (2*barsDiameter) + (2*dispYaxis)) + globalY )
                fourthPointTrap = ((length - concreteCover) + golbalX , (width - (concreteCover+ (2*barsDiameter) + (2*dispYaxis))) + globalY)
                
                #Right Trapezoidal
                trapezoidal(firstPointTrap,secondPointTrap,thirdPointTrap,fourthPointTrap)

        #Bars Along Length
        barsAlongLength (noOfBarsAlongLength , dispXaxisFromCenters , firstPoint+golbalX , firstPoint+globalY)
        barsAlongLength (noOfBarsAlongLength , dispXaxisFromCenters , firstPoint+golbalX , secondPoint+globalY) 

        #Bars Along Width
        barsAlongWidth (noOfBarsAlongWidth , dispYaxisFromCenters , (mainStirrupLength-barsDiameter),firstPoint+golbalX , dispYaxisFromCenters+firstPoint+globalY )
        #color attribute of drawen entities 
        color = 7

        #Outer Cover
        drawing.add(dxf.rectangle((golbalX,globalY) , length, width, color=color))

        #Main Stirrup
        drawing.add(dxf.rectangle((concreteCover+golbalX,concreteCover+globalY) , mainStirrupLength, mainStirrupWidth, color=color))

        #Rectangle Stirrups Along Length
        for i in range(noOfRecStirrupsAlongLength):
            drawing.add(dxf.rectangle((RecStirrupOffesetsAlongLength[i]+golbalX,concreteCover+globalY) , RecStrirruplenghts[i], mainStirrupWidth, color=color))

        #Single Stirrups Along Length
        for i in range(noOfSingleStirrupsAlongLength):
            drawing.add(dxf.rectangle((SingleStirrupOffesetsAlongLength[i]+golbalX,concreteCover+globalY) , singleStirruplength , mainStirrupWidth, color=color))

        #Rectangle Stirrups Along Width
        for i in range(noOfRecStirrupsAlongWidth):
            drawing.add(dxf.rectangle((concreteCover+golbalX, RecStirrupOffesetsAlongWidth[i]+globalY) , mainStirrupLength , RecStrirrupWidths[i], color=color))

        #Single Stirrups Along Width
        for i in range(noOfSingleStirrupsAlongWidth):
            drawing.add(dxf.rectangle((concreteCover+golbalX, SingleStirrupOffesetsAlongWidth[i]+globalY) , mainStirrupLength , singleStirrupwidth, color=color))

        golbalX = golbalX + shift
    
    golbalX = 0 
    globalY = globalY + shift

drawing.save()
print(savingdir)