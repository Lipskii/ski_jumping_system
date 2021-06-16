import React, {Component} from "react";
import Layout from "./hoc/Layout/Layout";
import {Route, Switch} from 'react-router-dom'
import NotFound from "./containers/NotFound";
import Results from "./containers/Results/Results";
import ShowResults from "./containers/Results/ShowResults";
import asyncComponent from "./hoc/asyncComponent/asyncComponent";
import SkiJumpers from "./containers/SkiJumpers/SkiJumpers";
import ShowSkiJumper from "./containers/SkiJumpers/ShowSkiJumper";
import Hills from "./containers/Hills/Hills";
import ShowHill from "./containers/Hills/ShowHill";
import ShowSeries from "./containers/Series/ShowSeries";
import ShowChampionship from "./containers/Championships/ShowChampionship";
import Login from "./components/Login";
import AuthService from "./services/auth.service";

const asyncVenues = asyncComponent(() => {
    return import("./containers/DB/Venues/DBVenues")
})
const asyncCompetitions = asyncComponent(() => {
    return import("./containers/DB/Competitions/DBCompetitions")
})
const asyncSkiClubs = asyncComponent(() => {
    return import("./containers/DB/SkiClubs/DBSkiClubs")
})
const asyncAthletes = asyncComponent(() => {
    return import("./containers/DB/Athletes/DBAthletes")
})
const asyncJury = asyncComponent(() => {
    return import("./containers/DB/Jury/DBJury")
})
const asyncHills = asyncComponent(() => {
    return import("./containers/DB/Hills/DBHills")
})


class App extends Component {

    state = {
        currentUser: undefined,
        showModeratorBoard: false
    }

    constructor(props) {
        super(props);
        this.state = {
            currentUser: undefined,
            showModeratorBoard: false
        };
    }

    componentDidMount() {
        const user = AuthService.getCurrentUser();

        if (user) {
            this.setState({
                currentUser: user,
                showModeratorBoard: user.roles.includes("ROLE_MODERATOR"),
            });
        }
    }


    render() {
        console.log("APP")
        console.log(this.state)

        const routesModerator = (
            <Switch>
                <Route path="/dbCompetitions" component={asyncCompetitions}/>
                <Route path="/dbClubs" component={asyncSkiClubs}/>
                <Route path="/dbHills" component={asyncHills}/>
                <Route path="/dbJury" component={asyncJury}/>
                <Route path="/dbAthletes" component={asyncAthletes}/>
                <Route path="/dbVenues" component={asyncVenues}/>
                <Route path="/skiJumpers" component={SkiJumpers}/>
                <Route path="/showSeries/:series" component={ShowSeries}/>
                <Route path="/showChampionships/:championship" component={ShowChampionship}/>
                <Route path="/hills" component={Hills}/>
                <Route path="/hill/:hill" component={ShowHill}/>
                <Route path="/showResults/:competition" component={ShowResults}/>
                <Route path="/skiJumper/:skiJumper" component={ShowSkiJumper}/>
                <Route path="/" component={Results}/>
                <Route component={NotFound}/>
            </Switch>
        )

        const routesBasicUser = (
        <Switch>
            <Route exact path="/login" component={Login}/>
            <Route path="/skiJumpers" component={SkiJumpers}/>
            <Route path="/showSeries/:series" component={ShowSeries}/>
            <Route path="/showChampionships/:championship" component={ShowChampionship}/>
            <Route path="/hills" component={Hills}/>
            <Route path="/hill/:hill"  component={ShowHill}/>
            <Route path="/showResults/:competition"  component={ShowResults}/>
            <Route path="/skiJumper/:skiJumper"  component={ShowSkiJumper}/>
            <Route exact path="/" component={Results}/>
            <Route component={NotFound}/>
        </Switch>
        )


        return (
            <Layout>
                {this.state.showModeratorBoard ? routesModerator : routesBasicUser}
            </Layout>
        )
    }
}

export default App;
