import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      person: null,
    };
  }

  // Asynchronous API call (Exact snippet from the hint image)
  async componentDidMount() {
    const url = "https://api.randomuser.me/";
    const response = await fetch(url);
    const data = await response.json();
    this.setState({ person: data.results[0], loading: false });
    console.log(data.results[0]);
  }

  render() {
    if (this.state.loading) {
      return <div>Loading...</div>;
    }

    if (!this.state.person) {
      return <div>No user found</div>;
    }

    const { title, first, last } = this.state.person.name;
    const { large } = this.state.person.picture;

    return (
      <div style={{ margin: '50px 0 0 150px' }}>
        <h2>
          {title} {first} {last}
        </h2>
        <img src={large} alt="User Profile" />
      </div>
    );
  }
}

export default Getuser;