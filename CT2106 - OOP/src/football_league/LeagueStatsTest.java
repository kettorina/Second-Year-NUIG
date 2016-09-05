package football_league;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeagueStatsTest {

	LeagueStats leagueStats = new LeagueStats();
	
	@Before
	public void setUp() throws Exception {
		League league = new League("League of Ireland");
		leagueStats.add(league);//adding league to LeagueStats
		
		Division div1 = new Division("Shamrock");//divisions
		Division div2 = new Division("Hearts");
		
		league.add(div1);//adding divisions to league
		league.add(div2);
		
		Team team1 = new Team("Sharks");//teams
		Team team2 = new Team("Dolphins");
		Team team3 = new Team("Fish");
		Team team4 = new Team("Seaweed");
		
		div1.add(team1);//adding teams to divisions
		div2.add(team2);
		div1.add(team3);
		div2.add(team4);
		
		Player player1 = new Player(19,5,3);//players
		Player player2 = new Player(19,6,0);
		Player player3 = new Player(20,7,17);
		Player player4 = new Player(20,8,14);
		Player player5 = new Player(18,9,3);
		Player player6 = new Player(21,10,1);
		Player player7 = new Player(21,4,7);
		Player player8 = new Player(21,7,3);
		Player player9 = new Player(21,10,1);
		Player player10 = new Player(21,4,7);
		Player player11 = new Player(17,9,6);
		Player player12 = new Player(19,10,9);
		
		team1.add(player1);//adding players to teams
		team2.add(player2);
		team1.add(player3);
		team2.add(player4);
		team1.add(player5);
		team2.add(player6);
		team3.add(player7);
		team3.add(player8);
		team3.add(player9);
		team4.add(player10);
		team4.add(player11);
		team4.add(player12);
	}
	/**
	 * @return the number of divisions in League
	 */
	@Test
	public void getNumDivisions() {
		int expectedNumDivision = 2;
		int numDivisions = leagueStats.getNumDivisions();
		assertTrue(expectedNumDivision==numDivisions);
	}
	/**
	 * @return the number of teams in a league
	 */
	@Test
	public void getNumTeams() {
		int expectedNumTeams = 4;
		int numTeams = leagueStats.getNumTeams();
		assertTrue(expectedNumTeams==numTeams);
	}
	/**
	 * @return the number of goals in a division
	 */
	@Test
	public void getGoalsForDivision() {
		int expectedGoalsForDivision = 34;
		int numGoalsForDivision = leagueStats.getGoalsForDivision("Shamrock");
		assertEquals(expectedGoalsForDivision, numGoalsForDivision);
	}
	/**
	 * @return the number of goals in a division
	 */
	@Test
	public void getNumGoalsForTeam() {
		double expectedGoalsForTeam=23;
		double numGoalsForTeam=leagueStats.getGoalsForTeam("Sharks");
		
		assertTrue(expectedGoalsForTeam==numGoalsForTeam);
		
	}
	/**
	 * @return the average age of the players in a team
	 */
	@Test
	public void getAveAgeOfTeam() {
		double expectedAveAge=19;
		double aveAgeTeam=leagueStats.getAveAgeofTeam("Sharks");
		
		assertEquals(expectedAveAge,aveAgeTeam,0.01);
	}
}
