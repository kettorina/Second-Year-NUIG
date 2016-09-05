% HouseHeat_Data of single space cuboid house

%%Geometry of a cuboid house
lenHouse = input('Enter the length of the house in m: ');
widHouse = input('Enter the width of the house in m: ');
htHouse = input('Enter the heigth of the house in m: ');
areaHouse = 2*(lenHouse*widHouse) + 2*(widHouse*htHouse) +2*(lenHouse*htHouse);
volumeHouse = lenHouse*widHouse*htHouse;
areaWall=areaHouse - (lenHouse*widHouse);

fprintf('Area of the house %i in m^2', areaHouse);
fprintf('\nVolume of the house %i in m^3\n', volumeHouse);

%%Reads in parameters of windows
totalareaWindows = 0;
numWindows = input('Enter the number of windows: ');
for i=1:numWindows
  htWindows = input('Enter the height of window: ');
  widWindows = input('Enter the width of window: ');
  areaWindows = htWindows*widWindows;
  totalareaWindows = totalareaWindows+areaWindows;
end

%%Reads in parameters of doors
totalareaDoors = 0;
numDoors = input('Enter the number of doors: ');
for i=1:numDoors
  htDoors = input('Enter the height of doors: ');
  widDoors = input('Enter the width of doors: ');
  areaDoors = htDoors*widDoors;
  totalareaDoors = totalareaDoors+areaDoors;
end


%%Total area of windows and doors and takes in U-value (in this case we use
%%one value for every door and window


%Area of roof
roofArea = lenHouse*widHouse;
U_value_roof = input('Enter u-value of roof: ');

totalareawindr = totalareaDoors + totalareaWindows;
U_value_windr = input('Enter u-value of doors and windows: ');    

%%Area of walls - area of windows & doors and takes in U-value
totalareaWalls = areaWall - totalareawindr;
U_value_walls = input('Enter u-value of walls: ');


%%Getting overall House Thermal Resistance
U_wall_tot=totalareaWalls*U_value_walls;
U_windr_tot=totalareawindr*U_value_windr;
U_roof_tot=roofArea*U_value_roof;
U_tot=U_wall_tot+U_windr_tot+U_roof_tot;

Rtot=1/U_tot;
Req=Rtot/(totalareaWalls+totalareawindr+roofArea);
fprintf('Overall House Thermal Resistance is %i in m^2K/W', Rtot);

%%Problem Constants

TinIC = 20;% inside temperature
c=1005.4;% specific heat capacity of air
airDensity = 1; %kg/m^3
M=volumeHouse*airDensity;%volume * density
flowrate=0.5;
Mdot=flowrate*3600; 
cost=.19;%kWhr
THeater=40;

choice=input('\nEnter 1 for January, enter 2 for August: ');

switch(choice)
    case 1
        
            filename='jan_week_2012';
            time=(0:167)';
            GainSine = xlsread(filename,'E2:E10081');
            Weekly=GainSine(1:60:end);
            plot(time,Weekly)
        
    case 2 
            filename='aug_week_2014';
            time=(0:167)';
            GainSine = xlsread(filename,'E1:E10080');
            Weekly=GainSine(1:60:end);
            plot(time,Weekly)
   
    end
    
    