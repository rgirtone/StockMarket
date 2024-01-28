Student name: Ramona Cristina Girtone
Student number: 200538154

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Investor]

This superclass is extended into at least two subclasses called [MutualFund, CorporateInvestor, Individual Investor]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [MutualFunds] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [mutualFundID, nav and isActive.]

These/this new properties/property are used by the subclass in the following way: [A mutual fund has a minimum number of different shares bought by a sole investor, as opposed to no minimum number of shares, that are potentially the same, in Investor class. Thus, mutualFundID gives the class its own identification number. The net average value is used to calculate what the average amount per unit of the fund is worth. This is done by combining the prices of minimum number of different shares bought and dividing that by the quantity of total shares. This is different than the average rate of share in Investor superclass because it refers to the average of all shares bought by the investor, potentially the same. isActive is used to check if the minimum of 3 different types of shares was met in the fund. Investor superclass does not have a minimum number of shares to be bought thus there is no threshold to activate the class (as long as the number of shares exceeds 0). mutualFundID is used at lines 17, 25, 31, 91. Nav is used at lines 19, 26, 36, 92. isActive is used at lines 41, 62, 73, 93.]

Subclass [MutualFunds] extends the superclass by overriding the following methods (there must be at least one): [addShare, removeShare, toString. Line numbers (respectively) : 59, 71 and 100.]

These overridden methods are used in the working code in the following places: [addShare method is used in MutualFund and Individual Investor files called at lines 60 and 50 respectively. removeShare is used in Mutual Fund and Corporate Investor files called at lines 83 and 77 respectively. toString is used in Individual Investor, Corporate Investor and Mutual Fund called at lines 50, 93 and 101 respectively.]

Subclass 2.

Subclass [IndividualInvestor] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Amount available, Check if amount is available for investment, or whether the minimum amount to invest exceeds the available amount, Returns a new String representation of an Individual Investor instance as opposed to an Individual instance alone.]

These/this new properties/property are used by the subclass in the following way: [An individual investor class considers the amount of shares bought by a sole investor as opposed to one or more investors. We need to check if the amount that the investor has is enough to buy the minimum number of shares required to make an investment. For that we need a new property, specifically an instance object amountAvailable that checks the user's input matches the set price times the minimum number os shares bought by the sole investor. If both records match, the amount is stored and the number of shares are recorded in his portfolio. This property is used at lines 10, 16, 21, 26, 35, 42 and 54.]

Subclass [IndividualInvestor] extends the superclass by overriding the following methods (there must be at least one): [Overridden methods - toString, addShare. Lines 49 and 31 respectively.]

These overridden methods are used in the working code in the following places: [addShare method is used in MutualFund and Individual Investor files called at lines 39 and 50 respectively. toString method is used in Mutual Fund, Corporate Investor and Individual Investor files called at lines 101, 93 and 50 respectively.]


LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in []. The name of the superclass used in this example is [Investor] and the subclasses used are [].

Late dynamic binding can be seen in [.

[Explain briefly (no more than four sentences), why this example of polymorphism is necessary in your code.]

Example 2.

The substitution principle can be seen in use in [class name and line number where substitution is used]. The name of the superclass used in this example is [name of superclass] and the subclasses used are [names of subclasses].

Late dynamic binding can be seen in [class name and line number].

[Explain briefly (no more than four sentences), why this example of polymorphism is necessary in your code.]
