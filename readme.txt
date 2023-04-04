Required JDK 17 or higher

-----------------------------------------------------------------------------------

Endpoint for creation of subscription
/api/subscription/insert
HTTP METHOD TYPE POST

example json body:
{
    "quotation": {
        "beginningOfInsurance": "2022-01-01",
        "insuredAmount": 22,
        "dateOfSigningMortgage": "2022-01-01",
        "customer": {
            "firstName": "Peter",
            "lastName": "Gebriel",
            "middleName": null,
            "email": "peter.gabriel@email.com",
            "phoneNumber": "777888999",
            "birthDate": "1993-06-06"
        }
    },
    "startDate": "2020-01-01",
    "validUntil": "2023-03-31"
}

-----------------------------------------------------------------------------------

Endpoint for retrieving subscription
/api/subscription/retrieve/{id}
HTTP METHOD TYPE GET

-----------------------------------------------------------------------------------

Endpoint for creation of quotation
/api/quotation/insert
HTTP METHOD TYPE POST

example json body:
{
    "beginningOfInsurance": "2018-01-01",
    "insuredAmount": 100,
    "dateOfSigningMortgage": "2018-01-01",
    "customer": {
        "firstName": "Marcel",
        "lastName": "Mrkva",
        "middleName": "Martin",
        "email": "marcel.mrkva@email.com",
        "phoneNumber": "123321123",
        "birthDate": "1990-01-01"
    }
}

-----------------------------------------------------------------------------------

Endpoint for updating customer
/api/customer/update/{id}
HTTP METHOD TYPE PUT

example json body:
{
    "firstName": "Hana",
    "lastName": "Mrkvova",
    "middleName": null,
    "email": "hana.mrkvova@email.com",
    "phoneNumber": "987654321",
    "birthDate": "1991-12-12"
}

