% Whale_Cell Function 2
function [t,y]=time_sinus_fn(fs,f0,duration)
%Create t vector, which uses dur, from the first function
t=0:1/fs:duration;

%Create the harmonics
y1=sin(2*pi*f0*t);
y2=sin(2*pi*2*f0*t);
y3=sin(2*pi*3*f0*t);
y=y1+y2+y3;
end