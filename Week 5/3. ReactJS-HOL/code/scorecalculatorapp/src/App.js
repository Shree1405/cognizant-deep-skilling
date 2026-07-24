import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="Shubaashree Suresh"
        School="ABC Higher Secondary School"
        Total={475}
        goal={5}
      />
    </div>
  );
}

export default App;