% Kinetic Energy Visualisation
m=0:1:10;%mass
v=0:1:100;%velocity
[m,v]=meshgrid(m,v);
K_energy=0.5*m.*v.^2;
surf(m,v,K_energy)
%image(m,v,K_energy
axis xy
colorbar
xlabel('Mass (kg)')
ylabel('Velocity(m/s)')
title('Kinetic Energy = 0.5 * Mass * (Velocity)^2 Jekaterina Zenkevica')
