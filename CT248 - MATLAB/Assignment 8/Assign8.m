% Wind and solar power

time=(0:10079)';

file_name_wind='jan_week_2012';
windspeed=xlsread(file_name_wind,'I2:I10081');

max_output=10;%kW
pcoef5=[7.79e-05,-0.0032,0.0385,-0.05,-.014,0.09];

area=20;%m^2
file_name_solar='jan_week_2012';
solarpower=xlsread(file_name_solar,'M2:M10082');