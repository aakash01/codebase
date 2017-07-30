ATM Design

ATM machine should be able to handle following things

ATM M/C funcionalites
1. Load Cash
2. Support different denominations


Transactions supported:
Based on the card type, different transactions can be supported

1. Check Balance
2. Withdraw Cash
3. Update pin
4. Register for Credit Card


ATM m/c can go to different states
1. MAINTANANCE MODE
2. TRANSACTION_IN_PROGRESS
3. TRANSACTION_FAILED
4. TRANSACTION_COMPLETED
5. START
7. FAILED

EVENTs
1. INSERT_CARD
2. ENTER_MAINTAINANCE_MODE
3. EXIT_MAINTAINANCE_MODE
4. CANCEL

UML

BankingService
----------------
User getUser(String Bank, String card)
boolean authenticateUser(TransactionContext, String pin)
long checkBalance(TransactionContext context)
void debitAmount(TransactionContext context, long amount)
boolean changePin(TransactionContext context, String pin)


CashInventory
----------------
addDenomination()
dispenseAmount(long amount)

TransactionContext
------------------
transactionId
User


AtmContext
----------



ATMSM
------
state
------
transition(Event event, AtmContext context)
autoTransition(Event event, AtmContext context)







Flow:
1. InsertCard 
2. Ask for Pin
3. Validate User
4. Show Transaction Options
    a. Withdraw Money
        i. Debit Money
       ii. Dispense Cash
      iii. Exit
    b. Show Balance
        i. Display Balance
       ii. Exit
1. Maintainance Mode
    i. Add Money
   ii. Add Currency
   






