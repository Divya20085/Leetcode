SELECT firstName,lastName,city,state
FROM Person
left JOIN Address
ON Person.personId = Address.personId;