% Whale_Cell Function 3

function[]= plot_decay_fn(y_fn,time,fs)

% Create exp decay fn by asking the user K and R
K=input('Enter amplitude: ');
R=input('Enter decay constant: ');
A=(K*exp(-R*time)).*sin(2*pi*0.5*R*time);
call=A.*y_fn;

%Plot the graph and play through soundcard
soundsc(call,fs)
plot(time,call)
end