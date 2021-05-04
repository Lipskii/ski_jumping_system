import {Header5} from "../../components/StyledComponents";
import React from "react";
import {Bar} from "react-chartjs-2";

const OverallStandingsBarChart = (props) => {
    let standings = []
    let labels = []

    for(const standing of props.overallStandings){
            standings.push(standing.ranking)
            labels.push(standing.season.season)
    }

    const data = {
        labels: labels,
        datasets: [{
            data: standings,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 205, 86, 0.2)',
            ],
            borderColor: [
                'rgb(255, 99, 132)',
                'rgb(255, 159, 64)',
                'rgb(255, 205, 86)',
            ],
            borderWidth: 1
        }]
    };

    return (
        <div>
            <Header5 style={{marginTop: "3px", textAlign: "left"}}>World Cup Standings</Header5>
            <div>
                <Bar
                    type={"bar"}
                    data={data}
                    height={30}
                    options={{ maintainAspectRatio: false }} />
            </div>

        </div>
    )
}



export default OverallStandingsBarChart