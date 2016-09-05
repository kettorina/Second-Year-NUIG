% January Weather Data
%% Part 1
file_name='Jan_temp_2015.xlsx';
%imports the file creates a time vector and extracts weekly temperature by
%an hour
original=xlsread(file_name);
time=(1:1:168)';
hourly=original(1:60:end);

%extracts min and max coordinates
[MinY,MinX]=min(hourly);
[MaxY,MaxX]=max(hourly);

%plots a graph 
figure
subplot(3,1,1)
plot(time,hourly,'k',MinX,MinY, 'b +',MaxX,MaxY, 'r +');
xlabel('Time in hours');
ylabel('Dry bulb temp in Celsius');
title_str=('January Weather');
title(title_str);
data_str=('Temperature');
data_str1=['Min ',num2str(MinY)];
data_str2=['Max ',num2str(MaxY)];
legend(data_str,data_str1,data_str2);


%if the input isn't satisfied the user is stuck within the while loop 
day=0;
while(day<1 || day>7)
    day=input('Select from 1-7: ');
end
%extracts info for specific day and creates a vector
dailytemp=hourly((1+(day-1)*24):(day*24));
dailytime=(1:1:24)';

%creates a polynomial with coef 3 and 7
subplot(3,1,2)
pcoef_3=polyfit(dailytime,dailytemp,3);
pcoef_7=polyfit(dailytime,dailytemp,7);
xlabel('Time in hours');
ylabel('Temperature in celsius');
title_str=['January Day ' num2str(day) ' 2015'];
title(title_str);
hold on 
sfit=(1:0.1:24);
x_ord=polyval(pcoef_7,sfit);
y_ord=polyval(pcoef_3,sfit);
plot(dailytime,dailytemp,'k');
plot(sfit,y_ord,'g');
plot(sfit,x_ord,'r');
legend('Actual Data','Polyfit 3', 'Polyfit 7');
hold off

%% Part 2

% Find the peak of a specific day (1 peak per day)
[MinY,MinX]=min(dailytemp);
[MaxY,MaxX]=max(dailytemp);

hold on
%Generate time vector and find the max of the day (peak)
subplot(3,1,3)
[m,n]=size(dailytemp);

% Generate function coefficient matrix X
peak1=MaxY;
X=[ones(size(dailytime)) cos((2 * pi/24)*(dailytime-peak1))];
s_coef=X\dailytemp;

% Plot the data
tfit=(1:0.2:m)';
yfit=[ones(size(tfit)) cos((2 *pi/24)*(tfit-peak1))]*s_coef;
plot(tfit,yfit,'r',dailytime,dailytemp,'k-');
xlabel('Time in hours');
ylabel('Temperature in celsius');
title_str1=['January Day ' num2str(day) ' 2015'];
legend('Sinusoidal model','Actual Data');
title(title_str1);
hold off


