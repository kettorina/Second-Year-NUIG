%% Weather Data
file_name='IRUSE_weather_Jan2015.xlsx';

%% Read in file for day one
Time_1=xlsread(file_name,'B2:B1439');
Windspeed_1=xlsread(file_name,'C2:C1439');
Windgust_1=xlsread(file_name,'D2:D1439');
Atmp_1=xlsread(file_name,'E2:E1439');

%% Read in file for day two
Time_2=xlsread(file_name,'B1440:B2879');
Windspeed_2=xlsread(file_name,'C1440:C2879');
Windgust_2=xlsread(file_name,'D1440:D2879');
Atmp_2=xlsread(file_name,'E1440:E2879');

%% Read in file for day three
Time_3=xlsread(file_name,'B2880:B4319');
Windspeed_3=xlsread(file_name,'C2880:C4319');
Windgust_3=xlsread(file_name,'D2880:D4319');
Atmp_3=xlsread(file_name,'E2880:E4319');

%% Read in file for day four
Time_4=xlsread(file_name,'B4320:B5759');
Windspeed_4=xlsread(file_name,'C4320:C5759');
Windgust_4=xlsread(file_name,'D4320:D5759');
Atmp_4=xlsread(file_name,'E4320:E5759');

%% User input and switch statemnt
day=input('Select day 1-4: ');

switch day
    case 1
        figure
        subplot(3,1,1)
        plot(Time_1,Windgust_1)
        title('Time v Wind speed (3 sec gust) for day 1 Jekaterina Zenkevica')
        xlabel('Time min')
        ylabel('Wind speed (3 sec gust) m/s')
        
        subplot(3,1,2)
        plot(Time_1,Atmp_1)
        title('Time v Atmospheric Pressure for day 1 Jekaterina Zenkevica')
        xlabel('Time min')
        ylabel('Atm. Pressure mbar')
        
        subplot(3,1,3)
        CorrCoef_1=corrcoef([Atmp_1,Windgust_1]);
        scatter(Atmp_1, Windgust_1,'filled')
        title(sprintf(' The correl coeff between wind gust and atmospheric pressure is %f\n', CorrCoef_1(2,1)))
        xlabel('Atm. Pressure mbar')
        ylabel('Wind gust m/s')
        fprintf(' The correl coeff between wind gust and atmospheric pressure is %f\n', CorrCoef_1(2,1));
    case 2

        figure
        subplot(3,1,1)
        plot(Time_2,Windgust_2)
        title('Time v Wind speed (3 sec gust) for day 2 Jekaterina Zenkevica')
        xlabel('Time min')
        ylabel('Wind speed (3 sec gust) m/s')
        
        subplot(3,1,2)
        plot(Time_2,Atmp_2)
        title('Time v Atmospheric Pressure for day 2 Jekaterina Zenkevica')
        xlabel('Time min')
        ylabel('Atm. Pressure mbar')
        
        subplot(3,1,3)
        CorrCoef_2=corrcoef([Atmp_2,Windgust_2]);
        scatter(Atmp_2, Windgust_2,'filled')
        title(sprintf(' The correl coeff between wind gust and atmospheric pressure is %f\n', CorrCoef_2(2,1)))
        xlabel('Atm. Pressure mbar')
        ylabel('Wind gust m/s')
        fprintf(' The correl coeff between wind gust and atmospheric pressure is %f\n', CorrCoef_2(2,1));
        
    case 3
        figure
        subplot(3,1,1)
        plot(Time_3,Windgust_3)
        title('Time v Wind speed (3 sec gust) for day 3 Jekaterina Zenkevica')
        xlabel('Time min')
        ylabel('Wind speed (3 sec gust) m/s')
        
        subplot(3,1,2)
        plot(Time_3,Atmp_3)
        title('Time v Atmospheric Pressure for day 3 Jekaterina Zenkevica')
        xlabel('Time min')
        ylabel('Atm. Pressure mbar')
        
        subplot(3,1,3)
        CorrCoef_3=corrcoef([Atmp_3,Windgust_3]);
        scatter(Atmp_3, Windgust_3,'filled')
        title( sprintf(' The correl coeff between wind gust and atmospheric pressure is %f\n', CorrCoef_3(2,1)));
        xlabel('Atm. Pressure mbar')
        ylabel('Wind gust m/s')
        fprintf(' The correl coeff between wind gust and atmospheric pressure is %f\n', CorrCoef_3(2,1));
    case 4
        
        figure
        subplot(3,1,1)
        plot(Time_4,Windgust_4)
        title('Time v Wind speed (3 sec gust) for day 4 Jekaterina Zenkevica')
        xlabel('Time min')
        ylabel('Wind speed (3 sec gust) m/s')
        
        subplot(3,1,2)
        plot(Time_4,Atmp_4)
        title('Time v Atmospheric Pressure for day 4 Jekaterina Zenkevica')
        xlabel('Time min')
        ylabel('Atm. Pressure mbar')
        
        subplot(3,1,3)
        CorrCoef_4=corrcoef([Atmp_4,Windgust_4]);
        scatter(Atmp_4, Windgust_4,'filled')
        title(sprintf(' The correl coeff between wind gust and atmospheric pressure is %f\n', CorrCoef_4(2,1)))
        xlabel('Atm. Pressure mbar')
        ylabel('Wind gust m/s')
        fprintf(' The correl coeff between wind gust and atmospheric pressure is %f\n', CorrCoef_4(2,1));
end

