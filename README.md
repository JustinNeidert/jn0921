# jn0921

To whom it may concern,

The main function takes an array of Strings as input. The array must have a non-zero multiple of 4 Strings for the application to do anything. Every set of 4 Strings will act as input for a new RentalAgreement all in a single Checkout instance.

I created this application with dual functionality seen in the DatabaseAccessor class. I had never used MyBatis before. So I made my best attempt at implementing the MyBatis version of the class in the commented sections, and implemented the non-MyBatis version in the non-commented parts of the class. Because I wasn't sure if any users of this would bother connecting it to an actual database, the DatabaseAccessor class will currently function without one, having the database data hardcoded as switch-case blocks. If this is in any way unsatisfactory, I am willing to alter it to meet expectations.

Enjoy, Justin Neidert
