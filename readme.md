# Coins Project
## Sprint 2
### Sprint Goal
The goal of the sprint is to address a change request. Our client wishes to have separate and distinguishable coin objects for the various coin types (e.g., quarter, dime). And, as always, our code meets our corporate requirements: checkstyle, unit testing.
### Sprint tasks
1. Refactor Coin as an abstract class
2. Create two-level coin hierarchy with Coin at top and Dollar, HalfDollar, Quarter, Dime, Nickel, Penny classes extending Coin. These classes should pass checkstyle and pass tests.
3. Update CoinTest to support changes in Coin class.
4. Write JUnit test classes for the concrete coin classes (e.g., Dime, Penny).
5. Write a Demo class that demonstrates our code (Coin class) satisfies customer requirements.
### Domain details
Client wants separate and distinguishable coin objects instead of a singular object that has varying field values. In essence, the software should reflect, or model, the physical reality. The physical reality is that quarters are different kinds of objects from pennies even though they have some commonalities.

Client still wants to be able to create multiple coin objects of various value denominations. Most attributes are "built in" to the coin denomination; for example, images and mottos for coins are fixed. Consequently, constructor doesn't need many parameters and there should not be any way to change these attributes once they are set. (Coins don't change after construction!) **NEW DESIGN:** The Quarter constructor knows all the attribute values and needs a superclass constructor that accepts all these.

United States coins specifications are indicated in table below.
Familiar name | value | frontMotto | backMotto | frontLabel | backLabel | frontImage | backImage | valueDescription | ridged edge | metallurgy
--------------| ----- | ---------- | --------- | ---------- | --------- | ---------- | --------- | ---------------- | ----------- | ----------
Penny | 0.01 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "A_Lincoln" | "Lincoln_Memorial" | "ONE CENT" | no | "Copper"
Nickel | 0.05 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "T_Jefferson" | "Jefferson_Memorial" | "FIVE CENTS" | no | "Cupro-Nickel"
Dime | 0.10 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "F_Roosevelt" | "Torch_Branches" | "ONE DIME" | yes | "Cupro-Nickel"
Quarter | 0.25 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "G_Washington" | "Eagle" | "QUARTER DOLLAR" | yes | "Cupro-Nickel"
HalfDollar | 0.50 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "J_Kennedy" | "Presidential_Seal" | "HALF DOLLAR" | yes | "Cupro-Nickel"
Dollar | 1.00 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "S_Anthony" | "Moon_Eagle" | "ONE DOLLAR" | yes | "Cupro-Nickel"
