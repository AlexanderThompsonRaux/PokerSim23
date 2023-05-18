# PokerSim23
Simple Poker hand analyzer

Alexander Thompson
at.raux@gmail.com
0728007475


The build script included will run the App as well as the Unit Test. The unit test can be toggled on or off in the App Config file.

The Main file will use the Controllers to:
  - Create a standard deck of Cards (Cards are made up of a Face and Suit string value).
  - Shuffel the Deck of created Cards.
  - Deal a Hand of Cards.
  - Analyze the Hand.
  - Post the data to the View.

The Config file is used to specify static variables like handSize, gameType, faces, suits and to toggle the unitTest.
  - This is more for future proofing when we start introducing new variants into the game, the Config file can be used to configure the setup before running the App.

I added a few concideration points and upgrade possibilities in the code as comments.

I introduced an error handling shortcode system catered more towards clients/users. It simply lets you know that the app ran into an error with a Code (ex. DC001) and a basic description (ex. 'noValue error') with a label to indicate that they should Contact the administrator.
  - This serves two purposes
      > 1. Give enough information to a client/user to know what to do (Call Administrator) and what caused the error(noValue error) for more learnerd users.
      > 2. When the client/user passes the error message to the Administrator and then to the Developers, they can imediately identify the location of the issue (ctrl+F).
