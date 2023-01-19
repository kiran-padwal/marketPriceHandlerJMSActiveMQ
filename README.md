# marketPriceHandlerJMSActiveMQ
It uses Embedded JMS Active MQ for communicating in real time where publisher send messages to the Queue and Subscriber receives the message from the queue and saves in the H2 in-mem database which can be consumed by clients.
A subscriber implements the JMS Active MQ Subscriber which listens to the market prices(message) published by the producer. 
Each message is a CSV string (format - 106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001).
With an incoming price, for each price a margin (add commission) function is implemented, assumming 
as -0.1% on bid, +0.1% on ask (subtract from bid, add to ask).
Publish the adjusted price to REST endpoint - below are the endpoints
localhost:8081/rest/getAllUpdatedPrice
localhost:8081/rest/getAllUpdatedPriceOrderByDateDESC
localhost:8081/rest/getLatestPriceByInstrument/EUR/JPY this will get the latest price of the instrument (EUR/JPY)
After running the application test messages will be published and received by the Subscriber and prints on the console with the adjusted price and saves in the database
for other clients to consume
