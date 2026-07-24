import office from "./office.jpeg";

function App() {

  const element = "Office Space";

  const jsxatt = (
    <img
      src={office}
      width="25%"
      height="25%"
      alt="Office Space"
    />
  );

  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai"
    },
    {
      Name: "TCS",
      Rent: 65000,
      Address: "Bangalore"
    },
    {
      Name: "Cognizant",
      Rent: 45000,
      Address: "Hyderabad"
    },
    {
      Name: "Infosys",
      Rent: 75000,
      Address: "Pune"
    }
  ];

  return (
    <div>

      <h1>{element}, at Affordable Range</h1>

      {jsxatt}

      <hr />

      {
        officeList.map((item, index) => {

          let colorClass = "";

          if (item.Rent <= 60000) {
            colorClass = "textRed";
          } else {
            colorClass = "textGreen";
          }

          return (
            <div key={index}>

              <h2>Name: {item.Name}</h2>

              <h3 className={colorClass}>
                Rent: Rs. {item.Rent}
              </h3>

              <h3>Address: {item.Address}</h3>

              <hr />

            </div>
          );
        })
      }

    </div>
  );
}

export default App;