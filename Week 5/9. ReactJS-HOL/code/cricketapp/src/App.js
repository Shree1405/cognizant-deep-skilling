import { ListofPlayers, Scorebelow70 } from "./ListofPlayers";
import ListofIndianPlayers, {
  OddPlayers,
  EvenPlayers,
  IndianPlayers,
} from "./IndianPlayers";

function App() {
  const players = [
    { name: "Sachin1", score: 95 },
    { name: "Dhoni2", score: 90 },
    { name: "Virat3", score: 68 },
    { name: "Rohit4", score: 65 },
    { name: "Yuvraj5", score: 60 },
    { name: "Raina6", score: 72 },
    { name: "Jadeja7", score: 80 },
    { name: "Ashwin8", score: 55 },
    { name: "Bumrah9", score: 78 },
    { name: "Shami10", score: 50 },
    { name: "Gill11", score: 88 },
  ];

  const IndianTeam = [
    "Sachin1",
    "Dhoni2",
    "Virat3",
    "Rohit4",
    "Yuvraj5",
    "Raina6",
  ];

  var flag = true;

  if (flag === true) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />

        <hr />

        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <h1>Indian Team</h1>

        <h2>Odd Players</h2>
        {OddPlayers(IndianTeam)}

        <hr />

        <h2>Even Players</h2>
        {EvenPlayers(IndianTeam)}

        <hr />

        <h1>List of Indian Players Merged:</h1>
        <ListofIndianPlayers IndianPlayers={IndianPlayers} />
      </div>
    );
  }
}

export default App;