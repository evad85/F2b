package is.hbv401g.dummy;

public class FootballPlayer {
	
	private final String teamName;
	private final String name;
	
	public Statistics[] stats;
	
	private double 	 pickProbability; //how likely is this player to be in final team squad.
	private int 	 goalsConceded;
	private int 	 marketValue;
	private int	 score;
	private int 	 yellowCards;
	private Position position;
	private String 	 picturePath;
	private int	 ownGoals;
	private int 	 redCards;
	private int 	 minutes;
	private int 	 assists;
	private int 	 goals;
	private int 	 saves;
	private int 	 minimumValue;
	
	
	//
	//CONSTUCTOR
	//
	public FootballPlayer( String name, String teamName, String pos ){
		this.teamName = teamName;
		this.name 	  = name;
		
		this.reset();
		
		this.stats = new Statistics[18];
		
		for(int i = 0; i<18; i++){
			this.stats[i] = new Statistics();
		}
		
		//FIND POSITION
		//	this.position gets object from enum Position
		//	that match with String value pos.
		
		for(Position position : Position.values() ){
			if( position.getPos().equals( pos ) ){
				this.position = position;
			}
		}
	}
	
	private void reset(){
		this.score = 0;
		this.minimumValue = 100;
	}
	
	//
	//UPDATE METHODS
	//
	public void updateFootballPlayer( int roundNumber){
		this.statsUpdate( roundNumber );
		this.scoreUpdate( roundNumber );
	}
	
	public void updateFootballPlayer(){
		this.marketValueUpdate();
	}
	
	
	private void statsUpdate( int roundNumber ){
		this.setGoalsConceded( this.stats[roundNumber].getGoalsConceded() + this.goalsConceded );
		this.setYellowCards( this.stats[roundNumber].getYellowCards() + this.yellowCards );
		this.setOwnGoals( this.stats[roundNumber].getOwnGoals() + this.ownGoals );
		this.setRedCards( this.stats[roundNumber].getRedCards() + this.redCards );
		this.setMinutes( this.stats[roundNumber].getMinutes() + this.minutes );
		this.setAssists( this.stats[roundNumber].getAssists() + this.assists );
		this.setGoals( this.stats[roundNumber].getGoals() + this.goals ); 
		this.setSaves( this.stats[roundNumber].getSaves() + this.saves );
	}
	
	
	
	//Calculate football player value from all his statistics
	private void marketValueUpdate(){
		if(this.minutes == 0){
			this.minutes = 1;
		}
		
		//Different coefficient Value for each position
		double GKCoefficient = 1.3;
		double DFCoefficient = 1.4;
		double MFCoefficient = 1.5;
		double FWCoefficient = 1.7;
		
		//			goals  saves	assists	goals/min  redC 	yellowC 	goalsC		ownG
		int[] GK = { 15,  	1, 		4, 		10000*1, 	5, 		2, 			1/15, 		0 };
		int[] DF = { 15,  	0,  	4,  	1000*1, 	5, 		2, 			1/20, 		0 };
		int[] MF = { 6,  	0,  	4,   	200*1, 		5, 		2, 			1/20, 		0 };
		int[] FW = { 5, 	0,  	4,   	200*1, 		5, 		2, 			1/30, 		0 };
		
		int marketValue = minimumValue;
		if(this.position == Position.GK){
			marketValue *= GKCoefficient;
			marketValue += calcMarketValue( GK );
		} else if(this.position == Position.DF){
			marketValue *= DFCoefficient;
			marketValue += calcMarketValue( DF );
		} else if(this.position == Position.MF){			
			marketValue *= MFCoefficient;
			marketValue += calcMarketValue( MF );	
		} else if(this.position == Position.FW){
			marketValue *= FWCoefficient;
			marketValue += calcMarketValue( FW );
		}
		marketValue = (int) Math.floor( marketValue );
		this.setMarketValue( marketValue  );
	}
	
	//Algorithm for to calculate value for footballPlayer
	private int calcMarketValue( int[] a ){
		int goals_per_min = (int)((goals)/minutes);
		int marketValue=(int)	(a[0]*goals
								+a[1]*saves
								+a[2]*assists
								+a[3]*goals_per_min
								-a[4]*redCards
								-a[5]*yellowCards
								-a[6]*goalsConceded
								-a[7]*ownGoals);		
		return marketValue;
	}

	//Calculate football player score from last game statistics
	private void scoreUpdate( int roundNumber ){
		if(this.minutes == 0){
			this.minutes = 1;
		}
		
		//		goals|saves|assists|min|redC|yellowC|goalsC|ownG|bonusGoalsC
		int[] GK={6,	3, 	  3,	45,  3, 	 1, 	 2, 	2,	 4};
		int[] DF={6,    0,    3,    45,  3, 	 1, 	 2, 	2,	 4};
		int[] MF={5,    0,    3,    45,  3, 	 1, 	 1, 	2, 	 1};
		int[] FW={4,	0,    3,    45,  3, 	 1, 	 1, 	2,	 0};
		
		int newScore = this.score;
		if(this.position == Position.GK){
			newScore += this.calcScore(GK, roundNumber);
		} else if(this.position == Position.DF){
			newScore += this.calcScore(DF, roundNumber);
		}else if(this.position == Position.MF){
			newScore += this.calcScore(MF, roundNumber);
		}else if(this.position == Position.FW){
			newScore += this.calcScore(FW, roundNumber);
		}
		this.setScore( this.score + newScore );
	}
	
	// returns calculate score from LAST match
	private int calcScore(int[] a, int roundNumber ){
		
		//Get last match statistics
		Statistics lastGame = stats[ roundNumber ];
		
		int newScore = 1;
		
		//Bonus score if player has no goals conceded
		if(this.goalsConceded == 0){
			newScore += a[ a.length-1 ];
		}
		
		//main calculation
		newScore =(int)(   a[0]*lastGame.getGoals()
						+1/a[1]*lastGame.getSaves()
						+  a[2]*lastGame.getAssists()
						+1/a[3]*lastGame.getMinutes()
						-  a[4]*lastGame.getRedCards()
						-  a[5]*lastGame.getYellowCards()
						-1/a[6]*lastGame.getGoalsConceded()
						-  a[7]*lastGame.getOwnGoals());
		return newScore;
	}
	
	
	//
	//SET METHODS
	//
	public void setPicturePath( String picturePath ){
		this.picturePath = picturePath;
	}
	public void setPickProbability( double pickProbability ){
		this.pickProbability = pickProbability;
	}
	
	public void setGoalsConceded( int goalsConceded ){
		this.goalsConceded = goalsConceded;
	}
	public void setYellowCards( int yellowCards ){
		this.yellowCards = yellowCards;
	}
	public void setMarketValue( int marketValue ){
		this.marketValue  = marketValue;
	}
	public void setOwnGoals( int ownGoals ){
		this.ownGoals = ownGoals;
	}
	public void setRedCards( int redCards ){
		this.redCards = redCards;
	}
	public void setMinutes( int minutes ){
		this.minutes = minutes;
	}
	public void setAssists( int assists ){
		this.assists = assists;
	}
	public void setGoals( int goals ){
		this.goals = goals;
	}
	public void setSaves( int saves ){
		this.saves = saves;
	}
	public void setScore(int score) {
		this.score = score;
	}
	


	//
	//GET METHODS
	//
	public double getPickProbability( ){
		return this.pickProbability;
	}
	public int getGoalsConceded( ){
		return this.goalsConceded;
	}
	public Statistics[] getStats( ){
		return this.stats;
	}
	public int getMarketValue( ){
		return this.marketValue;
	}
	public String getPicturePath( ){
		return this.picturePath;
	}
	public int getYellowCards( ){
		return this.yellowCards;
	}
	public String getTeamName( ){
		return this.teamName;
	}
	public Position getPosition( ){
		return this.position;
	}
	public int getRedCards( ){
		return this.redCards;
	}
	public int getOwnGoals( ){
		return this.ownGoals;
	}
	public int getMinutes( ){
		return this.minutes;
	}
	public int getAssists( ){
		return this.assists;
	}
	public String getName( ){
		return this.name;
	}
	public int getGoals( ){
		return this.goals;
	}
	public int getSaves( ){
		return this.saves;
	}

	public int getScore() {
		return this.score;
	}
}