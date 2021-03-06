PROJECT TITLE: Tron
AUTHORS: Vaed Prasad

Problem Description
This month your challenge is to write a Tron AI to compete against other bots. The bots with the highest TruSkill rankings win the competition. Code (written in Java, C++ or Python) should be uploaded as a zip file, and will be executed on our ranking server.

Problem Specifics
The playing field is a 16 by 16 grid. Bots can move North, South, East, or West. Bots can also get a map of the current playing field, represented as a 2D array of integers.

If a square is empty, the integer value is zero. A value of 1 or 2 represents that the square is currently occupied by that player number. A value of 3 shows that the square has been taken by player 1, while a value of 4 shows that a square has been taken by player 2. The networking of sending commands and reading the map is already implemented in the starter packages.

In order to test your bot, you can run the command python Tron_Environment.py in the command line. Make sure you are using python 3. When it asks for the command for each bot, just type in the command you would ordinarily use to run the bot: for example, java TronBot for Java (assuming it's already compiled) or python3 TronBot.py for Python. To save time, you can also pass your start commands as command line parameters like so: python Tron_Environment.py "python TronBot.py" "java TronBot".

Be aware that as networking is done through printing and reading from the command line, you cannot use traditional console IO such as print, std::cout or System.out.print. Instead, we provide the log and logln functions. The starter packages can be found here.

Restrictions
You can use anything on Wikipedia for reference. Use of the Internet for algorithmic purposes is acceptable, but you may not copy and paste code. Use of websites such as python.org, the Java API, and cplusplus.com is encouraged. Existing StackOverflow answers can also be referenced as a guide. Collaboration between students is encouraged, but your solutions should be your own.
