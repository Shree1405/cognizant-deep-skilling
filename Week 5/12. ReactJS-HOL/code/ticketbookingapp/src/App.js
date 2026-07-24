import React, { Component } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

class App extends Component {
  constructor() {
    super();
    this.state = {
      isLoggedIn: false
    };
  }

  login = () => {
    this.setState({
      isLoggedIn: true
    });
  };

  logout = () => {
    this.setState({
      isLoggedIn: false
    });
  };

  render() {
    if (this.state.isLoggedIn) {
      return (
        <div style={{ marginLeft: "170px", marginTop: "100px" }}>
          <UserPage onLogout={this.logout} />
        </div>
      );
    }

    return (
      <div style={{ marginLeft: "170px", marginTop: "100px" }}>
        <GuestPage onLogin={this.login} />
      </div>
    );
  }
}

export default App;