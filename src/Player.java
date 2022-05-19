//not using scanner,etc as no use here. here only setting nd getting of things we are doing

public class Player {
         private String name;
         private char symbol;

			public Player(String name, char symbol) {
				setName(name);
				setSymbol(symbol);

			}

			public void setName(String name) {
				if (!name.isEmpty()) {
					this.name = name;
				}
			}

			public void setSymbol(char symbol) {
				if (symbol != '\0') {
					this.symbol = symbol;
				}
			}

			public String getName() {
				return this.name;
			}

			public char getSymbol() {
				return this.symbol;
			}

}
