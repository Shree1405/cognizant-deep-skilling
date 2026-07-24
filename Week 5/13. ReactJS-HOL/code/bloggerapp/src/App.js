import React from 'react';
import { books, courses, blogs } from './data';
import './App.css';

function App(props) {
  // 1. Element variable for Book Details using map() and key
  const bookdet = (
    <ul>
      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  // 2. Conditional/Ternary evaluation for Course Details
  const coursedet = courses ? (
    <ul>
      {courses.map((course) => (
        <div key={course.id}>
          <h2>{course.cname}</h2>
          <p><b>{course.date}</b></p>
        </div>
      ))}
    </ul>
  ) : null;

  // 3. Short-circuit (&&) operator evaluation for Blog Details
  const content = blogs && (
    <div>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h2>{blog.title}</h2>
          <p><b>{blog.author}</b></p>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );

  return (
    <div className="main-container">
      <div className="column mystyle1">
        <h1>Course Details</h1>
        {coursedet}
      </div>

      <div className="column st2">
        <h1>Book Details</h1>
        {bookdet}
      </div>

      <div className="column v1">
        <h1>Blog Details</h1>
        {content}
      </div>
    </div>
  );
}

export default App;