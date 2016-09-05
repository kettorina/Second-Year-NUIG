% SEAI Vehicle Data

file_name_1='SEAI_fuel_2000.xlsx';
[N,text_file_1]=xlsread(file_name_1);

EngineSize = N(:,1);
Petrol2000 = N(:,2);
Diesel2000 = N(:,5);

file_name_2='SEAI_fuel_2011.xlsx';
[Y,text_file_2]=xlsread(file_name_2);

Petrol2011 = Y(:,2);
Diesel2011 = Y(:,5);

h1=figure(1)
plot(EngineSize,Diesel2000,'r:+', EngineSize,Diesel2011,'b:+')
legend('Diesel2000','Diesel2011')
title('Year 2000/2011 Irish Cars Diesel Consumption SEAI Jekaterina Zenkevica')
xlabel('Engine Size cc')
ylabel('Fuel Consumption 1/100km')

h2=figure(2)
plot(EngineSize,Petrol2000,'r:+', EngineSize,Petrol2011,'b:+')
legend('Petrol2000','Petrol2011')
title('Year 2000/2011 Irish Cars Petrol Consumption SEAI Jekaterina Zenkevica')
xlabel('Engine Size cc')
ylabel('Fuel Consumption 1/100km')