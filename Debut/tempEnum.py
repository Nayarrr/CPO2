from enum import Enum, auto

class temperature_unit(Enum):
	Kelvin = 'KELVIN'
	Celsius = 'CELSIUS'
	Fahrenheit = 'FAHRENHEIT'

# MAIN 

# Déclaration d'une variable prenant une des alternatives de l'enum :
possible = temperature_unit('KELVIN')
possible_aussi = temperature_unit.Kelvin
impossible = temperature_unit('Kelvin')

# Iteration sur les valeurs :
for u in temperature_unit:
	print(u.name, u.value)

# Savoir si une valeur entrée par l'utilisateur est dans un enum :
prop = 'KELVIN'
if prop in [u.name for u in temperature_unit]:
	print('%s mesure acceptée(détection par liste comprehension)' % prop)
else:
	print('%s mesure refusée (détection par liste comprehension)' % prop)

#### Autre possibilité sans passer par une compréhension de listes :
def valid_unit(proposed : str ) -> bool :
    try:
        choice = temperature_unit(proposed)
    except ValueError:
        # more informative error message
        raise ValueError('%s is not valid; possible choices: %s' %
                (proposed, list(temperature_unit) ) )
# MAIN - suite
prop1 = 'KELVIN'
try:
	valid_unit(prop1)
except:
	print("%s n'est pas une unité acceptée" % prop1)

prop2 = 'K'
try:
	valid_unit(prop2)
except:
	print("%s n'est pas une unité acceptée" % prop2)