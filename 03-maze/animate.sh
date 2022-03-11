FILE=$1
javac KDriver.java 
echo -e '\e[?25l'; #hide cursor
java KDriver $FILE ANIMATE! | sed 's/#/\x1B[37;47m#\x1b[0m/g ; s/@/\x1B[30;43m@\x1b[0m/g  ; s/E/\x1B[30;43mE\x1b[0m/g';
echo -e '\e[?25h'; #show cursor
echo -e '\e[0m'; #default colors

