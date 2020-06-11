# bookManager
Spring Boot Project to manage a book storage

-You can sent a GET request to this route to get all books the server currently have
https://dry-brushlands-00702.herokuapp.com/api/book

-Send a PUT request to https://dry-brushlands-00702.herokuapp.com/api/book/id
  replace id with an existing id from https://dry-brushlands-00702.herokuapp.com/api/book
  will return the book with that id

-Send a POST request to https://dry-brushlands-00702.herokuapp.com/api/book

with the following body template:
 
{
  "title": "book name",
  "price":"00.00",
  "author":"author name"
}

to add a book

-Send a PUT request to https://dry-brushlands-00702.herokuapp.com/api/book/id
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

-Send a DELETE request to https://dry-brushlands-00702.herokuapp.com/api/book/6776baa0-74b0-4d91-b91f-2aabb19306e2

  will delete that book
