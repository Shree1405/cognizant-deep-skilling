import React from "react";

function GuestPage(props) {
  return (
    <div>
      <h1>Please sign up.</h1>
      <button onClick={props.onLogin}>
        Login
      </button>
    </div>
  );
}

export default GuestPage;