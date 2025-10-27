package refugeoly;

import java.util.ArrayList;
import refugeoly.actions.BankGivesMoney;
import refugeoly.actions.GoToAction;
import refugeoly.actions.PayMoneyAction;
import refugeoly.actions.RollDiceAction;
import refugeoly.actions.StayAction;

public class Board {

    private ArrayList<Square> squares;

    public Board() {
        squares = new ArrayList<>();
        initializeBoard();
    }

    private void initializeBoard() {
        squares.add(new Square(0, "Country in conflict.", "In the last few years the main number of refugees come form Iraq, Syria, Pakistan, Libya, Afghanistan and Kurdistan, but also from many countries in Africa.", this));
        squares.add(new Square(1, "Food for the journey. Pay $100.", "This is key once leaving a country in conflict. The journey is always difficult to predict. Outsourcing food is fundamental once a refugee starts a journey.", new PayMoneyAction(100, false), this));
        squares.add(new Square(2, "Car. You get a free lift. Roll dice.", "NGO volunteers or simply samaritans often help refugees by taken them to countries borders for free in their personal cars.", new RollDiceAgainAction(), this));
        squares.add(new Square(3, "Communication gear. Mobile phone and sim card. Pay $300 to the Mafia Bank.", "Phone contact is an essential kit for the journey. Refugees required to be able to contact family or the ma a via phone during the journey to safety. Often the Mafia obligates refugees to buy their phones through them, to controls their numbers and communications.", new PayMoneyAction(300, true), this));
        squares.add(new Square(4, "Army Control. You go back to war box (0).", "Often refugees find sudden Army Controls during their journey. The military stop them and in most of the cases divert them back to their countries of origin.", new GoToAction(0), this));
        squares.add(new Square(5, "Border 1. Go back to war box (0).", "There are country borders in every country that the refugees have to go through. Refugees are often stuck in these ones till they have their documents checked or pay money for visas to corrupt army forces in order to carry on the journey.", new GoToAction(0), this));
        squares.add(new Square(6, "Mafia. Pay 1000$.", "Specialised in Refugees, Mafias have spread dramatically in the last few years. These ones have an enormous power in countries like Turkey and Libya. It is almost impossible to reach Europe without paying the Mafia.", new PayMoneyAction(1000, true), this));
        squares.add(new Square(7, "Live Vest. You have an extra life if you land in the sea (Box 10). ", "Once the refugees have reached the coast they must buy a life vest before they get on a boat. The Mafia sales these items, sometimes they don’t float.", new LifeVestAction(), this));
        squares.add(new Square(8, "GPS Location. Stay for a turn. ", "Before boarding the boats, the Mafia concentrates the refugees in specific places. The Mafia move them in groups towards the departure points.", new StayAction(), this));
        squares.add(new Square(9, "Boat. Pay 3000$ to the Mafia Bank. Roll dice.", "The average price for crossing the Mediterranean is around 3000$. Sometimes refugee families get a discount.", this));
        squares.add(new Square(10, "Dead at Sea. You are dead and out of the game. ", "Over 3000 people died and around 4000 have disappeared in the Mediterranean only in 2017.", new LooseAction(), this));
        squares.add(new Square(11, "You get sick. Stay one turn.", "The travelling conditions on the Mafia boats are terrible, lack of drinking water, enough fuel just to reach the coast, the extremely dangerous hygiene conditions and of course the uncertainty, It is very probable to arrived to the coast sick.", new StayAction(), this));
        squares.add(new Square(12, "You reach an EU coast. Roll dice.", "The lucky refugees that have made the sea journey and have reached an EU coast, start here another journey. Often some refugees are also tricked by the Mafia and land them in a beach not far from where they left. They are back in Libya or turkey.", new RollDiceAgainAction(), this));
        squares.add(new Square(13, "Tent and sleeping bag. Pay 200$ to the Mafia Bank.", "The Mafia does not allow refugees to carry much personal items with them. Once they arrived to an EU coast they have to buy essential stuff, a tent and a sleeping bag can be sold for 300$", new PayMoneyAction(200, true), this));
        squares.add(new Square(14, "Border Police. Stay one turn.", "The border police in many countries in Europe discretionally stop refugees from crossing. Sometimes keeping them for days next to the border controls.", new StayAction(), this));
        squares.add(new Square(15, "Border Control 2. Back to Border Control 1. ", "In some Border Controls in Europe, refugees are stopped and put in buses and taken to the previous country border.", new GoToAction(5), this));
        squares.add(new Square(16, "Refugee Camp. Pay 500$ to the Mafia bank to leave and roll dice. ", "The Mafia controls refugees all way through. Sometimes refugees have to pay the Mafia just to let them leave the camps.", this));
        squares.add(new Square(17, "Train. Roll dice.", "Short distance trains are used by refugees within countries.", new RollDiceAgainAction(), this));
        squares.add(new Square(18, "Red Cross Shelter. Jump to river crossing box (22).", "The Red Cross have a number of shelters in different parts of the European routes used by refugees. In those ones they provide of toilets, food and sometimes sleeping areas.", new GoToAction(22), this));
        squares.add(new Square(19, "Guard Dogs. Stay one turn.", "It has been reported that in some Eastern European countries police and civilians use guard dogs to track refugees.", new StayAction(), this));
        squares.add(new Square(20, "NGO Support. You receive 1000$ from NGO Bank.", "Some NGOs help refugees by giving them sums of money to enable them to carry on the journey.", new BankGivesMoney(1000), this));
        squares.add(new Square(21, "Theft. You lose 1500$.", "Robbery is very common in refugee camps. Some refugees lose all their savings due to thieves.", new PayMoneyAction(1500, false), this));
        squares.add(new Square(22, "River Crossing. Roll dice and go backwards by the number on the dice.", "There are many rivers to cross in order to avoid police control. Specially in winter these rivers are almost impossible to cross. Refugees sometimes spend days and weeks till the river level comes down and then can be crossed.", new RollDiceBackAction(), this));
        squares.add(new Square(23, "NGO Lift. Jump to family reunion box (29).", "NGO volunteers often give free lifts to refugees in private cars. Hidden them in the boot or covered with blankets.", new GoToAction(29), this));
        squares.add(new Square(24, "Border Police. Stay one turn.", "The border police in many countries in Europe discretionally stop refugees from crossing. Sometimes keeping then for days next to the border controls.", new StayAction(), this));
        squares.add(new Square(25, "Border Control 3. Back to border 2 (box 15).", "In some Border Controls in Europe, refugees are stopped and put in buses and taken to the previous country border.", new GoToAction(15), this));
        squares.add(new Square(26, "Asylum Paperwork. Pay 1000$ to Mafia Bank. Option A: Pay $1500 to Mafia Bank and roll dice. Option B: Don’t pay and stay 2 turns.", "Some refugees are pressurised by the Mafia to let them deal with the Asylum Seeker Paperwork, obviously under a payment that sometimes can reach big sums of money. In many of the cases these documents never appear or get lost.",new PayMoneyAction(1000, true), this));
        squares.add(new Square(27, "Storm. Stay one turn.", "Weather conditions in central Europe can be very extreme in winter. Often refugees get stuck for days and weeks in the middle of nowhere.", new StayAction(), this));
        squares.add(new Square(28, "UNHCR Aid. Roll dice.", "The United Nations High Commissioner for Refugees provides support in different parts of the refugee journey.", new RollDiceAgainAction(), this));
        squares.add(new Square(29, "Family Reunion. Jump to bus box (31).", "Most of refugees families can’t travel together, due to money or due to complexity of moving in groups. Some refugee families reunite in different parts of the journey. Sometimes parents send their children ahead alone as it is more probable for a child to get asylum.", new GoToAction(31), this));
        squares.add(new Square(30, "Right Wing Militia. Back to Border police box (24).", "Fascist Militias have spread dramatically along many country borders in Europe. These people act in Paramilitary way, uniformed and sometimes with real arms, beating, raping and torturing refugees.", new GoToAction(24), this));
        squares.add(new Square(31, "Mafia Bus. Pay 800$ to Mafia Bank. Roll dice.", "Mafia use buses to move long number of refugees from border to border. Due to stronger control of border policy, buses have been replaced by trucks or vans for this purpose. A long number of refugees have been found dead inside of abandoned lorries in car parks, petrol stations or even next to border controls by Mafia drivers.", this));
        squares.add(new Square(32, "Government Detention Camp. Stay one turn.", "All European countries have Detention Camps for illegal immigrants. Immigration detention refers to the government practice of detaining asylum seekers and other migrants for administrative purposes, typically to establish their identities, or to facilitate their immigration claims resolution and/or their removals. It is an administrative process rather than a criminal procedure. Detention time defers from country to country, also does the conditions inside of those ones in each country.", new StayAction(), this));
        squares.add(new Square(33, "Asylum Seeker Application rejected. Back to Train box (17) and Roll dice.", "Decisions often depend on whether the case owner and the person’s account to be believable. There are a number of ways that an applicant’s credibility may be damaged, for example, if they have given inaccurate or inconsistent information. Case owners must also take the applicant’s behaviour into account.", this));
        squares.add(new Square(34, "Border Police. Stay one turn.", "The border police in many countries in Europe discretionally stop refugees from crossing. Sometimes keeping then for days next to the border controls.", new StayAction(), this));
        squares.add(new Square(35, "Border Control 4. Back to Border 3 (box 25).", "In some Border Controls in Europe, refugees are stopped and put in buses and taken to the previous country border.", new GoToAction(25), this));
        squares.add(new Square(36, "Asylum Seeker Application Approved. You win.", "In The United Kingdom if the claim is allowed on the grounds of the 1951 Geneva Convention, either by the UK Border Agency or at appeal, the applicant gets Refugee Status, which lasts for five years. The UK Border Agency can review this grant of status during this time if there is good reason, such as if the circumstances in the country of origin have changed. After five years, if it is still unsafe for the person to return to their own country, they will be able to apply for a legal status known as Indefinite Leave to Remain (ILR) in the UK.", new Win(), this));
        squares.add(new Square(37, "Mafia. Pay 1000$ to Mafia Bank.", "Specialised Refugee Ma as have spread dramatically in the last few years. These ones have an enormous power in countries like Turkey, Afghanistan or Libya. It is almost impossible to reach Europe without paying the Mafia.", new PayMoneyAction(1000, true), this));
        squares.add(new Square(38, "Deported. You are sent back to war box (0).", "Deportation, legally speaking (UK) is the enforced removal of someone “for the public good”, usually after serving a criminal sentence in the UK. Removals and deportations are usually carried out either on a commercial airline (one person being removed/deported, usually escorted by security guards, and the other passengers are the public travelling for holiday or business) or by private charter flight (usually lots of people being removed/deported to the same country at the same time).", new GoToAction(0), this));
        squares.add(new Square(39, "New Home. You are finally accepted. You win.", "According to the European Parliament in 2015 and 2016 alone, more than 2.5 million people applied for asylum in the EU. Authorities in the member states issued 593,000 first instance asylum decisions in 2015 - over half of them positive. Most people who applied for protection at the height of the refugee crisis in 2015 had to wait until 2016 to receive their ruling. That year 1.1 million asylum decisions were made. 61% of those were positive with one third of applicants granted refugee status, the highest level of international protection.", new Win(), this));

        squares.get(9).addAction(new PayMoneyAction(3000, true));
        squares.get(9).addAction(new RollDiceAgainAction());
        squares.get(16).addAction(new PayMoneyAction(500, true));
        squares.get(16).addAction(new RollDiceAgainAction());
        squares.get(31).addAction(new PayMoneyAction(800, true));
        squares.get(31).addAction(new RollDiceAgainAction());

    }

    public void addSquare(Square square) {
        squares.add(square);
    }

    public Square getSquare(int number) {
        return squares.get(number);
    }

}
