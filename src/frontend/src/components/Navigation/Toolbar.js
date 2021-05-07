import React, {Component} from "react";
import { Nav, Navbar, NavDropdown} from "react-bootstrap";
import {LinkContainer} from 'react-router-bootstrap'
import AuthService from "../../services/auth.service";

class Toolbar extends Component {

    state = {
        user: undefined,
        showModeratorBoard: false
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
        return (
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" fixed="top">
                <LinkContainer to="/results">
                    <Navbar.Brand href="/">Ski Jumping Stats</Navbar.Brand>
                </LinkContainer>
                <Navbar.Toggle aria-controls="responsive-navbar-nav"/>
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <LinkContainer to="/skiJumpers">
                            <Nav.Link>Ski Jumpers</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/hills">
                            <Nav.Link>Hills</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/showSeries/9">
                            <Nav.Link>World Cup</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/showSeries/12">
                            <Nav.Link>Four Hills Tournament</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/showSeries/18">
                            <Nav.Link>Raw Air</Nav.Link>
                        </LinkContainer>
                        <NavDropdown title="Other Series" id="collasible-nav-dropdown">
                            {/*<LinkContainer to="/showSeries/9">*/}
                            {/*    <NavDropdown.Item>World Cup</NavDropdown.Item>*/}
                            {/*</LinkContainer>*/}
                            {/*<LinkContainer to="/showSeries/10">*/}
                            {/*    <NavDropdown.Item>Ski Flying World Cup</NavDropdown.Item>*/}
                            {/*</LinkContainer>*/}
                            {/*<LinkContainer to="/showSeries/12">*/}
                            {/*    <NavDropdown.Item>Four Hills Tournament</NavDropdown.Item>*/}
                            {/*</LinkContainer>*/}
                            {/*<LinkContainer to="/showSeries/18">*/}
                            {/*    <NavDropdown.Item>Raw Air</NavDropdown.Item>*/}
                            {/*</LinkContainer>*/}
                            <LinkContainer to="/showSeries/26">
                                <NavDropdown.Item>Continental Cup</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to="/showSeries/28">
                                <NavDropdown.Item>FIS Cup</NavDropdown.Item>
                            </LinkContainer>
                            <NavDropdown.Divider/>
                            <LinkContainer to="/showSeries/22">
                                <NavDropdown.Item>Summer Grand Prix</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to="/showSeries/27">
                                <NavDropdown.Item>Summer Continental Cup</NavDropdown.Item>
                            </LinkContainer>
                        </NavDropdown>
                        <NavDropdown title="Championships" id="collasible-nav-dropdown">
                            <LinkContainer to="/showChampionships/1">
                                <NavDropdown.Item>Olympic Games</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to="/showChampionships/3">
                                <NavDropdown.Item>World Championships</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to="/showChampionships/5">
                                <NavDropdown.Item>Ski Flying World Championships</NavDropdown.Item>
                            </LinkContainer>
                        </NavDropdown>
                        {/*<Nav.Link>SJS All Time Ranking</Nav.Link>*/}
                        {/*<Nav.Link>Stats</Nav.Link>*/}
                        {/*<Form inline>*/}
                        {/*    <FormControl type="text" placeholder="Search" className="mx-sm-2"/>*/}
                        {/*    <Button variant="secondary">Search</Button>*/}
                        {/*</Form>*/}
                    </Nav>
                    {this.state.showModeratorBoard ?
                        <NavDropdown id="collasible-nav-dropdown_two" title="DB Tools">
                            <LinkContainer to='/dbAthletes'>
                                <NavDropdown.Item>Athletes</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to='/dbCompetitions'>
                                <NavDropdown.Item>Competitions</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to='/dbHills'>
                                <NavDropdown.Item>Hills</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to='/dbJury'>
                                <NavDropdown.Item>Jury</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to='/dbClubs'>
                                <NavDropdown.Item>Ski clubs</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to='/dbVenues'>
                                <NavDropdown.Item>Venues</NavDropdown.Item>
                            </LinkContainer>
                            <LinkContainer to='/'>
                                <NavDropdown.Item onClick={() => {
                                    AuthService.logout()
                                    window.location.reload();
                                }}>Logout</NavDropdown.Item>
                            </LinkContainer>
                        </NavDropdown> : null}
                    <Nav className="mr-1">
                        <Nav.Link>About</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }

}


export default Toolbar