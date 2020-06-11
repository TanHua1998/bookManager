# bookManager
Spring Boot Project to manage a book storage

###### You can use Postman app as a client

* You can sent a GET request to this route to get all books the server currently have

https://dry-brushlands-00702.herokuapp.com/api/book

* To view a specific book, send a GET request to https://dry-brushlands-00702.herokuapp.com/api/book/id
  replace id with an existing id from https://dry-brushlands-00702.herokuapp.com/api/book

* To add a Book, Send a POST request to https://dry-brushlands-00702.herokuapp.com/api/book with the following body template:

        {
          "title": "book name",
          "price":"00.00",
          "author":"author name"
        }

* Send a PUT request to https://dry-brushlands-00702.herokuapp.com/api/book/id
  replace id with an existing id from https://dry-brushlands-00702.herokuapp.com/api/book
  with new body template to update an existing book
 
 Example:
 PUT to https://dry-brushlands-00702.herokuapp.com/api/book/6776baa0-74b0-4d91-b91f-2aabb19306e2
 with body
 
        {
          "title": "new name",
          "price":"00.00",
          "author":"new name"
        }

* Send a DELETE request to https://dry-brushlands-00702.herokuapp.com/api/book/6776baa0-74b0-4d91-b91f-2aabb19306e2 will delete that book
