% Tidal Currents for 3 days

pi
a=2*pi/12.41666;

x=0:0.1:72;

y=5*sin(a*x)
plot(x,y,'r-')
xlabel('Time in hours')
ylabel('Velocity speed in m/s')
title('Tidal currents for three days Jekaterina Zenkevica')

