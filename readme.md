
# springboot-rest-library-management-system
A complete Spring Boot example application for REST APIs; its purpose is to demonstrate various API .
## User

### 1. Add User [POST]
	http://localhost:8090/api/addUser

	    Request:
        {
            "name": "Aman Sagar",
            "status": "Active",
            "userName": "aman.sagar",
            "userPassword": "aman.sagar"
        }
    
	    Response:
    
        {
            "id": "6",
            "name": "Aman Sagar",
            "userName": "aman.sagar",
            "userPassword": "$2a$10$f0NBnxd814vbH3u.UJtx3OCgV20TJUH2/cH0TdtDM6hoztO6y.jMS",
            "joined_date": "2022-01-24",
            "status": "Active",
            "fine": 0,
            "role": [
                {
                    "roleName": "User",
                    "roleDescription": "default role for newly created user"
                }
            ]
        }

### 2. getAllUser [GET]
    http://localhost:8090/api/getAllUser
    Response:
    [
    {
        "id": "1",
        "name": "Ujjwal Kumar",
        "userName": null,
        "userPassword": null,
        "joined_date": "2022-01-17",
        "status": "Active",
        "fine": 3,
        "role": [
            {
                "roleName": "Admin",
                "roleDescription": "admin role for application"
            }
        ]
    },
    {
        "id": "2",
        "name": "Sid Tiwari",
        "userName": null,
        "userPassword": null,
        "joined_date": "2022-01-17",
        "status": "Active",
        "fine": 0,
        "role": []
    },
    {
        "id": "3",
        "name": "Sudhansu Pandey",
        "userName": null,
        "userPassword": null,
        "joined_date": "2022-01-17",
        "status": "Active",
        "fine": 0,
        "role": []
    },
    {
        "id": "4",
        "name": "Abhishek Singh",
        "userName": "abhishek.singh",
        "userPassword": "$2a$10$Lc8AnE9NDjPuUHYRT8Nt4OEc/s3T6Slwm1etC79yxi.6IZ8kwabt.",
        "joined_date": "2022-01-21",
        "status": "Active",
        "fine": 0,
        "role": [
            {
                "roleName": "Admin",
                "roleDescription": "admin role for application"
            }
        ]
    },
    {
        "id": "5",
        "name": "Saurab Kumar",
        "userName": "saurab.kumar",
        "userPassword": "$2a$10$cYDh9vvzBR9TMcfDCv1riO4k09Qc5aV5etfopCEpJn51Qrnp5IIDm",
        "joined_date": "2022-01-21",
        "status": "Active",
        "fine": 0,
        "role": [
            {
                "roleName": "User",
                "roleDescription": "default role for newly created user"
            }
        ]
    },
    {
        "id": "6",
        "name": "Aman Sagar",
        "userName": "aman.sagar",
        "userPassword": "$2a$10$f0NBnxd814vbH3u.UJtx3OCgV20TJUH2/cH0TdtDM6hoztO6y.jMS",
        "joined_date": "2022-01-24",
        "status": "Active",
        "fine": 0,
        "role": [
            {
                "roleName": "User",
                "roleDescription": "default role for newly created user"
            }
        ]
    }
    ]


	
### 3. getUserById [GET]
    http://localhost:8090/api/user/{id}
    Response:
    {
    "id": "1",
    "name": "Ujjwal Kumar",
    "userName": null,
    "userPassword": null,
    "joined_date": "2022-01-17",
    "status": "Active",
    "fine": 3,
    "role": [
        {
            "roleName": "admin",
            "roleDescription": "admin role for application"
        }
    ]
    }

### 4. getUserByUserName [GET]
    url: http://localhost:8090/api/user?userName=saurab.kumar
    Response:
    {
    "id": "5",
    "name": "Saurab Kumar",
    "userName": "saurab.kumar",
    "userPassword": "$2a$10$cYDh9vvzBR9TMcfDCv1riO4k09Qc5aV5etfopCEpJn51Qrnp5IIDm",
    "joined_date": "2022-01-21",
    "status": "Active",
    "fine": 0,
    "role": [
        {
            "roleName": "User",
            "roleDescription": "default role for newly created user"
        }
    ]
    }

### 5. updateUser [PUT]
    url:http://localhost:8090/api/user/update/1
    Request:
    {
    "name": "Aman Sagar Updated",
    "status": "Active"
    }

    Response:
    {
    "id": "1",
    "name": "Aman Sagar Updated",
    "userName": null,
    "userPassword": null,
    "joined_date": "2022-01-17",
    "status": "aman.sagar",
    "fine": 3,
    "role": [
        {
            "roleName": "admin",
            "roleDescription": "admin role for application"
        }
    ]
    }

### 5. Authenticate
    url: http://localhost:8090/authenticate

    Request:
    {
    "userName": "aman.sagar",
    "userPassword": "aman.sagar"
    }

    Response:
    {
    "user": {
        "id": "6",
        "name": "Aman Sagar",
        "userName": "aman.sagar",
        "userPassword": "$2a$10$f0NBnxd814vbH3u.UJtx3OCgV20TJUH2/cH0TdtDM6hoztO6y.jMS",
        "joined_date": "2022-01-24",
        "status": "Active",
        "fine": 0,
        "role": [
            {
                "roleName": "User",
                "roleDescription": "default role for newly created user"
            }
        ]
    },
    "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbWFuLnNhZ2FyIiwiZXhwIjoxNjQzMDE4NzU0LCJpYXQiOjE2NDMwMDA3NTR9._v43oyMkMIdlgrt_eN9ke7T7ZLdj4O-abNyt3aZFWtnxqezjMSsTi8ae6Iy4sldQVDFy-BwNmfuT7VWETHvKIQ"
    }

### 6. IssueBook [POST]

    url: http://localhost:8090/api/issueBook?userId=3&bookId=1
    Response:
    {
    "id": 3,
    "bookId": 1,
    "userId": 3,
    "loanDate": "2022-01-24",
    "returnDate": null,
    "fine": 0
    }


### 7. ReturnBook [PUT]

    url: http://localhost:8090/api/returnBook?userId=3&bookId=1
    Response:
    {
    "id": 3,
    "bookId": 1,
    "userId": 3,
    "loanDate": "2022-01-24",
    "returnDate": "2022-01-24",
    "fine": 3
    }   



## Book
### 1. Add Book [POST]
    url: http://localhost:8090/api/books

    Request:
    {
    "title": "Intro to SQL",
    "publication": "paytm",
    "copies": 3
    }

    Response:
    {
    "id": 4,
    "title": "Intro to SQL",
    "publication": "paytm",
    "copies": 3,
    "issuedCopies": 0,
    "author": null
    }
### 2. getAllBooks [GET]
    url: http://localhost:8090/api/books

    Response:
    [
    {
        "id": 1,
        "title": "Intro to java",
        "publication": "paytm",
        "copies": 4,
        "issuedCopies": 1,
        "author": "ujjwal"
    },
    {
        "id": 2,
        "title": "Intro to SQL",
        "publication": "paytm",
        "copies": 3,
        "issuedCopies": 0,
        "author": "sid"
    },
    {
        "id": 3,
        "title": "Springboot",
        "publication": "ujjwal publiation",
        "copies": 9,
        "issuedCopies": 0,
        "author": "ujjwal"
    },
    {
        "id": 4,
        "title": "Intro to SQL",
        "publication": "paytm",
        "copies": 3,
        "issuedCopies": 0,
        "author": null
    }
    ]
### 3. getBookById [GET]
    url: http://localhost:8090/api/books/{id}
    Response:
    {
    "id": 1,
    "title": "Intro to java",
    "publication": "paytm",
    "copies": 4,
    "issuedCopies": 1,
    "author": "ujjwal"
    }

### 4. updateBook [PUT]
    url: http://localhost:8090/api/books/{id}
    Request:
    {
    "title": "Intro to MySQL",
    "publication": "Paytm",
    "copies": 6,
    "author": "new author"
    }
    Response:
    {
    "id": 2,
    "title": "Paytm",
    "publication": "Paytm",
    "copies": 6,
    "issuedCopies": 0,
    "author": "new author"
    }

### 5. searchByTitle [GET]
    url: http://localhost:8090/api/books/search?title=Springboot
    Response:
    [
    {
        "id": 3,
        "title": "Springboot",
        "publication": "ujjwal publiation",
        "copies": 9,
        "issuedCopies": 0,
        "author": "ujjwal"
    }
    ]
### 6. searchByAuthor [GET]
    url: http://localhost:8090/api/books/searchByAuthor?author=sid
    Response:
    [
    {
        "id": 2,
        "title": "Intro to SQL",
        "publication": "paytm",
        "copies": 3,
        "issuedCopies": 0,
        "author": "sid"
    }
    ]

## Role
### 1. makeAdmin [PUT]
    url: http://localhost:8090/api//makeAdmin?userId=4
    Reponse:
    {
    "id": "4",
    "name": "Abhishek Singh",
    "userName": "abhishek.singh",
    "userPassword": "$2a$10$Lc8AnE9NDjPuUHYRT8Nt4OEc/s3T6Slwm1etC79yxi.6IZ8kwabt.",
    "joined_date": "2022-01-21",
    "status": "Active",
    "fine": 0,
    "role": [
        {
            "roleName": "Admin",
            "roleDescription": "admin role for application"
        }
    ]
    }

### 2. createNewRole
    url: http://localhost:8090/createNewRole
    Request:
    {
        "roleName": "user",
        "roleDescription": "default role for newly created user"
    }

    Response:
    {
        "roleName": "user",
        "roleDescription": "default role for newly created user"
    }


## Loan
### 1. getALLLoans [GET]
    url: http://localhost:8090/loans
    Response:
    [
    {
        "id": 1,
        "bookId": 1,
        "userId": 2,
        "loanDate": "2022-01-21",
        "returnDate": null,
        "fine": 0
    },
    {
        "id": 2,
        "bookId": 1,
        "userId": 1,
        "loanDate": "2022-01-21",
        "returnDate": "2022-01-21",
        "fine": 3
    }
    ]

### 2. getLoanByUserIdAndBookId [GET]
    url:http://localhost:8090/loan?userId=1&bookId=1
    Response:
    {
    "id": 2,
    "bookId": 1,
    "userId": 1,
    "loanDate": "2022-01-21",
    "returnDate": "2022-01-21",
    "fine": 3
    }