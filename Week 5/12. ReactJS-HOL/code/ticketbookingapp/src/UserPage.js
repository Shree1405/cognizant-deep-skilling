import React from "react";

function UserPage(props) {
  return (
    <div>
      <h1>Welcome back</h1>

      <button onClick={props.onLogout}>
        Logout
      </button>
    </div>
  );
}

export default UserPage;