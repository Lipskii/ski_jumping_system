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
            dataIndex: 'editionInfo',
            textWrap: 'word-break',
            render: editionInfo =>
                <div>
                    <div>
                        {editionInfo.name}
                    </div>
                    {editionInfo.largeHillCompetitionId !== '' ?
                        <div>
                            <a href={'/showResults/' + editionInfo.largeHillCompetitionId}
                               style={{color: "black", textDecoration: "underline"}} >
                                <small>
                                    Large hill results
                                </small>
                            </a>
                        </div>
                        : null}
                    {editionInfo.normalHillCompetitionId !== '' ?
                        <div>
                        <a href={'/showResults/' + editionInfo.normalHillCompetitionId}
                           style={{color: "black", textDecoration: "underline"}} >
                            <small>
                                Normal hill results
                            </small>
                        </a>
                    </div> : null}
                </div>,
            fixed: 'left'
        },
        {
            title:"Normal Hill",
            children: [
                {
                    title: "Winner",
                    dataIndex: 'winnerNormalHill',
                    textWrap: 'word-break',
                    render: winnerNormalHill => winnerNormalHill.map(winnerNormalHill => (
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
                            <a href={'/skiJumper/' + silverMedalistNormalHill.skiJumper.id}
                               style={{color: "black"}}>
                                <img alt={silverMedalistNormalHill.skiJumper.person.country.code}
                                          src={props.photos["flag_" + silverMedalistNormalHill.skiJumper.person.country.code]}/> {silverMedalistNormalHill.skiJumper.person.firstName} {silverMedalistNormalHill.skiJumper.person.lastName}
                            </a>
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
        }
    ];

    const data = [];
    for (const edition of props.editions) {

        let winnerNormalHill = []
        let silverMedalistNormalHill = []
        let bronzeMedalistNormalHill = []
        let winnerLargeHill = []
        let silverMedalistLargeHill = []
        let bronzeMedalistLargeHill = []
        let editionInfo = {
            name: edition.competitions[0].hillVersion.hill.venue.city.name + " " + edition.competitions[0].date1.slice(0, 4),
            largeHillCompetitionId: '',
            normalHillCompetitionId: ''
        }

        for (const competition of edition.competitions) {
           if(competition.hillVersion.hill.sizeOfHill.id === 4){
               editionInfo.largeHillCompetitionId = competition.id
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
               editionInfo.normalHillCompetitionId = competition.id
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
            countryCode: edition.city.region.country.code,
            competitions: edition.competitions,
            editionInfo: editionInfo,
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