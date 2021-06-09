import React from "react";
import {LinkContainer} from "react-router-bootstrap";
import {Table} from "antd";

const ChampionshipEditionsTable = (props) => {
    const columns = [
        {
            dataIndex: 'countryCode',
            textWrap: 'word-break',
            width: "50px",
            render: countryCode =>
                <div>
                    <img alt={countryCode} src={props.photos['flag_' + countryCode]}/>
                </div>,
            fixed: 'left'
        },
        {
            dataIndex: 'name',
            textWrap: 'word-break',
            render: name =>
                <div>
                    {name}
                </div>,
            fixed: 'left'
        },
        // {
        //     dataIndex: 'competitions',
        //     textWrap: 'word-break',
        //     render: competitions => competitions.map(competition => (
        //         <LinkContainer to={'/showResults/' + competition.id}
        //                        style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
        //             <div>
        //                 {competition.hillVersion.hill.sizeOfHill.designation}
        //             </div>
        //         </LinkContainer>
        //     )),
        // },
        {
            title:"Normal Hill",
            children: [
                {
                    title: "Winner",
                    dataIndex: 'winnerNormalHill',
                    textWrap: 'word-break',
                    render: winnerNormalHill => winnerNormalHill.map(winnerNormalHill => (
                        // <LinkContainer to={'/skiJumper/' + winnerNormalHill.skiJumper.id}
                        //                style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
                        //     <div><img alt={winnerNormalHill.skiJumper.person.country.code}
                        //               src={props.photos["flag_" + winnerNormalHill.skiJumper.person.country.code]}/> {winnerNormalHill.skiJumper.person.firstName} {winnerNormalHill.skiJumper.person.lastName}
                        //     </div>
                        // </LinkContainer>
                        <a href={'/skiJumper/' + winnerNormalHill.skiJumper.id}
                           style={{color: "black"}} >
                            <img alt={winnerNormalHill.skiJumper.person.country.code}
                                 src={props.photos["flag_" + winnerNormalHill.skiJumper.person.country.code]}/> {winnerNormalHill.skiJumper.person.firstName} {winnerNormalHill.skiJumper.person.lastName}
                        </a>
                    )),
                },
                {
                    title: "2. place",
                    dataIndex: 'silverMedalistNormalHill',
                    textWrap: 'word-break',
                    render: silverMedalistNormalHill => silverMedalistNormalHill.map(silverMedalistNormalHill => (
                        // <LinkContainer to={'/skiJumper/' + silverMedalistNormalHill.skiJumper.id}
                        //                style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
                            <a href={'/skiJumper/' + silverMedalistNormalHill.skiJumper.id}
                               style={{color: "black"}}>
                                <img alt={silverMedalistNormalHill.skiJumper.person.country.code}
                                          src={props.photos["flag_" + silverMedalistNormalHill.skiJumper.person.country.code]}/> {silverMedalistNormalHill.skiJumper.person.firstName} {silverMedalistNormalHill.skiJumper.person.lastName}
                            </a>
                            // <div>
                            //     <img alt={silverMedalistNormalHill.skiJumper.person.country.code}
                            //           src={props.photos["flag_" + silverMedalistNormalHill.skiJumper.person.country.code]}/> {silverMedalistNormalHill.skiJumper.person.firstName} {silverMedalistNormalHill.skiJumper.person.lastName}
                            // </div>
                    //    </LinkContainer>
                    )),
                },
                {
                    title: "3. place",
                    dataIndex: 'bronzeMedalistNormalHill',
                    textWrap: 'word-break',
                    render: bronzeMedalistNormalHill => bronzeMedalistNormalHill.map(bronzeMedalistNormalHill => (
                        <LinkContainer to={'/skiJumper/' + bronzeMedalistNormalHill.skiJumper.id}
                                       style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
                            <div><img alt={bronzeMedalistNormalHill.skiJumper.person.country.code}
                                      src={props.photos["flag_" + bronzeMedalistNormalHill.skiJumper.person.country.code]}/> {bronzeMedalistNormalHill.skiJumper.person.firstName} {bronzeMedalistNormalHill.skiJumper.person.lastName}
                            </div>
                        </LinkContainer>
                    )),
                },
            ]
        },
        {
            title:"Large Hill",
            children: [
                {
                    title: "Winner",
                    dataIndex: 'winnerLargeHill',
                    textWrap: 'word-break',
                    render: winnerLargeHill => winnerLargeHill.map(winnerLargeHill => (
                        <LinkContainer to={'/skiJumper/' + winnerLargeHill.skiJumper.id}
                                       style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
                            <div><img alt={winnerLargeHill.skiJumper.person.country.code}
                                      src={props.photos["flag_" + winnerLargeHill.skiJumper.person.country.code]}/> {winnerLargeHill.skiJumper.person.firstName} {winnerLargeHill.skiJumper.person.lastName}
                            </div>
                        </LinkContainer>
                    )),
                },
                {
                    title: "2. place",
                    dataIndex: 'silverMedalistLargeHill',
                    textWrap: 'word-break',
                    render: silverMedalistLargeHill => silverMedalistLargeHill.map(silverMedalistLargeHill => (
                        <LinkContainer to={'/skiJumper/' + silverMedalistLargeHill.skiJumper.id}
                                       style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
                            <div><img alt={silverMedalistLargeHill.skiJumper.person.country.code}
                                      src={props.photos["flag_" + silverMedalistLargeHill.skiJumper.person.country.code]}/> {silverMedalistLargeHill.skiJumper.person.firstName} {silverMedalistLargeHill.skiJumper.person.lastName}
                            </div>
                        </LinkContainer>
                    )),
                },
                {
                    title: "3. place",
                    dataIndex: 'bronzeMedalistLargeHill',
                    textWrap: 'word-break',
                    render: bronzeMedalistLargeHill => bronzeMedalistLargeHill.map(bronzeMedalistLargeHill => (
                        <LinkContainer to={'/skiJumper/' + bronzeMedalistLargeHill.skiJumper.id}
                                       style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
                            <div><img alt={bronzeMedalistLargeHill.skiJumper.person.country.code}
                                      src={props.photos["flag_" + bronzeMedalistLargeHill.skiJumper.person.country.code]}/> {bronzeMedalistLargeHill.skiJumper.person.firstName} {bronzeMedalistLargeHill.skiJumper.person.lastName}
                            </div>
                        </LinkContainer>
                    )),
                },
            ]
        },
        // {
        //     title: "Winner",
        //     dataIndex: 'winner',
        //     textWrap: 'word-break',
        //     render: winner => winner.map(winner => (
        //         <LinkContainer to={'/skiJumper/' + winner.skiJumper.id}
        //                        style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
        //             <div><img alt={winner.skiJumper.person.country.code}
        //                       src={props.photos["flag_" + winner.skiJumper.person.country.code]}/> {winner.skiJumper.person.firstName} {winner.skiJumper.person.lastName}
        //             </div>
        //         </LinkContainer>
        //     )),
        // },
        // {
        //     title: "2. place",
        //     dataIndex: 'silverMedalist',
        //     textWrap: 'word-break',
        //     render: silverMedalist => silverMedalist.map(silverMedalist => (
        //         <LinkContainer to={'/skiJumper/' + silverMedalist.skiJumper.id}
        //                        style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
        //             <div><img alt={silverMedalist.skiJumper.person.country.code}
        //                       src={props.photos["flag_" + silverMedalist.skiJumper.person.country.code]}/> {silverMedalist.skiJumper.person.firstName} {silverMedalist.skiJumper.person.lastName}
        //             </div>
        //         </LinkContainer>
        //     )),
        // },
        // {
        //     title: "3. place",
        //     dataIndex: 'bronzeMedalist',
        //     textWrap: 'word-break',
        //     render: bronzeMedalist => bronzeMedalist.map(bronzeMedalist => (
        //         <LinkContainer to={'/skiJumper/' + bronzeMedalist.skiJumper.id}
        //                        style={{cursor: "pointer", marginTop: "10px", marginBottom: "10px"}}>
        //             <div><img alt={bronzeMedalist.skiJumper.person.country.code}
        //                       src={props.photos["flag_" + bronzeMedalist.skiJumper.person.country.code]}/> {bronzeMedalist.skiJumper.person.firstName} {bronzeMedalist.skiJumper.person.lastName}
        //             </div>
        //         </LinkContainer>
        //     )),
        // },
    ];

    const data = [];
    for (const edition of props.editions) {

        let winnerNormalHill = []
        let silverMedalistNormalHill = []
        let bronzeMedalistNormalHill = []
        let winnerLargeHill = []
        let silverMedalistLargeHill = []
        let bronzeMedalistLargeHill = []
        for (const competition of edition.competitions) {
           if(competition.hillVersion.hill.sizeOfHill.id === 4){
               for (const result of competition.results) {
                   if (result.totalRank === 1) {
                       winnerLargeHill.push(result)
                   }
                   if (result.totalRank === 2) {
                       silverMedalistLargeHill.push(result)
                   }
                   if (result.totalRank === 3) {
                       bronzeMedalistLargeHill.push(result)
                   }
               }
           } else {
               for (const result of competition.results) {
                   if (result.totalRank === 1) {
                       winnerNormalHill.push(result)
                   }
                   if (result.totalRank === 2) {
                       silverMedalistNormalHill.push(result)
                   }
                   if (result.totalRank === 3) {
                       bronzeMedalistNormalHill.push(result)
                   }
               }
           }

        }
        data.push({
            key: edition.id,
            winnerNormalHill: winnerNormalHill,
            silverMedalistNormalHill: silverMedalistNormalHill,
            bronzeMedalistNormalHill: bronzeMedalistNormalHill,
            winnerLargeHill: winnerLargeHill,
            silverMedalistLargeHill: silverMedalistLargeHill,
            bronzeMedalistLargeHill: bronzeMedalistLargeHill,
            name: edition.competitions[0].hillVersion.hill.venue.city.name + " " + edition.competitions[0].date1.slice(0, 4),
            countryCode: edition.city.region.country.code,
            competitions: edition.competitions,
            ...edition
        })
    }

    console.log(data)

    return (
        <div>
            <h3 style={{textAlign: "center"}}>
                Editions
            </h3>
            <Table columns={columns} dataSource={data} pagination={false}/>
        </div>

    )
}

export default ChampionshipEditionsTable