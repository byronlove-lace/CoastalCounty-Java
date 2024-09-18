import javax.swing.JOptionPane;

class CoastalCounty
{
        // Data
        private String name;
        private String colours;
        private String largestTown;
        private short visitWorthinessRank;
        private String shortReview; private int population;
        private short area; // square miles

        // Constructor 
        public CoastalCounty(String cName, short cVisitWorthinessRank)
        {
                name = cName;
                visitWorthinessRank = cVisitWorthinessRank;
        }

        // Getter / Setter Methods
         
        public void setName(String newName)
        {
                name = newName;
        }

        public String getName()
        {
                return name;
        }

        public void setColours(String newColours)
        {
                colours = newColours;
        }

        public String getColours()
        {
                return colours;
        }

        public void setLargestTown(String newLargestTown)
        {
                largestTown = newLargestTown;
        }

        public String getLargestTown()
        {
                return largestTown;
        }

        public void setVisitWorthinessRank(short newVisitWorthinessRank)
        {
                visitWorthinessRank = newVisitWorthinessRank;
        }

        public short getVisitWorthinessRank()
        {
                return visitWorthinessRank;
        }

        public void setShortReview(String newShortReview)
        {
                shortReview = newShortReview;
        }

        public String getShortReview()
        {
                return shortReview;
        }

        public void setPopulation(int newPopulation)
        {
                population = newPopulation;
        }

        public int getPopulation()
        {
                return population;
        }

        public void setArea(short newArea)
        {
                area = newArea;
        }

        public short getArea()
        {
                return area;
        }

        // Main Method

        public static void main(String[] args)
        {
                // Set County Info 
                CoastalCounty mayo = new CoastalCounty("Mayo", (short)1);
                mayo.setColours("Green and Red");
                mayo.setLargestTown("Castlebar");
                mayo.setShortReview("Birthplace of Michael Davitt.");
                mayo.setPopulation(137231);
                mayo.setArea((short)2157);

                CoastalCounty galway = new CoastalCounty("Galway", (short)2);
                galway.setColours("Maroon and White");
                galway.setLargestTown("Galway");
                galway.setShortReview("Like Mayo but less cool.");
                galway.setPopulation(276451);
                galway.setArea((short)2354);

                CoastalCounty donegal = new CoastalCounty("Donegal", (short)3);
                donegal.setColours("Green and Gold");
                donegal.setLargestTown("Letterkenny");
                donegal.setShortReview("Absolutely not part of NI despite being in Ulster.");
                donegal.setPopulation(166321);
                donegal.setArea((short)2000);

                CoastalCounty sligo = new CoastalCounty("Sligo", (short)4);
                sligo.setColours("Black and White");
                sligo.setLargestTown("Sligo");
                sligo.setShortReview("Place where Yeats wrote his best poems.");
                sligo.setPopulation(70198);
                sligo.setArea((short)690);

                CoastalCounty[] coastalCounties = {mayo, galway, donegal, sligo};

                // User Input

                boolean countyFound = false;

                String userCountyName = JOptionPane.showInputDialog("Please enter the name of the " +
                                "West-Coast county you would like to learn about:");

                for (int i = 0; i < coastalCounties.length; ++i)
                {
                        if (userCountyName.equalsIgnoreCase(coastalCounties[i].getName()))
                        {
                                countyFound = true;

                                String userPopulationInput;
                                String userAreaInput;
                                int userPopulation;
                                short userArea;
                                int diffPopulation;
                                short diffArea;

                                userPopulationInput = JOptionPane.showInputDialog("Guess the population of this county: ");
                                userAreaInput = JOptionPane.showInputDialog("Guess the area of this county (in square miles): ");
                                userPopulation = Integer.parseInt(userPopulationInput);
                                userArea = Short.parseShort(userAreaInput);
                                // get absolute number (not positive or negative)
                                diffPopulation = Math.abs(coastalCounties[i].getPopulation() - userPopulation);
                                // Math.abs returns int (needs to be cast to short)
                                diffArea = (short)Math.abs(coastalCounties[i].getArea() - userArea);

                                String userCountyColours = coastalCounties[i].getColours();
                                String userLargestTown = coastalCounties[i].getLargestTown();
                                short userVisitWorthinessRank = coastalCounties[i].getVisitWorthinessRank();
                                String userShortReview = coastalCounties[i].getShortReview();

                                String userMessage = "Name: " + userCountyName + System.lineSeparator()
                                        + "County Colours: " + userCountyColours + System.lineSeparator()
                                        + "Largest Town: " + userLargestTown + System.lineSeparator()
                                        + "Visit Worthiness Rank: " + userVisitWorthinessRank + System.lineSeparator()
                                        + "Short Review: " + userShortReview + System.lineSeparator()
                                        + "Your population guess was off by " + diffPopulation + System.lineSeparator()
                                        + "Your area guess was off by " + diffArea;

                                        
                                if (diffPopulation == 0 || diffArea == 0)
                                        JOptionPane.showMessageDialog(null, "Good guess!"); 

                                JOptionPane.showMessageDialog(null, userMessage); 
                        }

                }

                if (countyFound == false)
                        JOptionPane.showMessageDialog(null, "County not found."); 
        }
}
