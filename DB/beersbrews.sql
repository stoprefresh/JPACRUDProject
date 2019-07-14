-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema beerlist
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `beerlist` ;

-- -----------------------------------------------------
-- Schema beerlist
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `beerlist` DEFAULT CHARACTER SET utf8 ;
USE `beerlist` ;

-- -----------------------------------------------------
-- Table `brewery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `brewery` ;

CREATE TABLE IF NOT EXISTS `brewery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `year_established` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `notes` VARCHAR(45) NULL,
  `website` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beer` ;

CREATE TABLE IF NOT EXISTS `beer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `abv` DECIMAL(4,2) NULL,
  `description` LONGTEXT NULL,
  `notes` VARCHAR(45) NULL,
  `brewery_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_beer_brewery_idx` (`brewery_id` ASC),
  CONSTRAINT `fk_beer_brewery`
    FOREIGN KEY (`brewery_id`)
    REFERENCES `brewery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS beeruser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'beeruser'@'localhost' IDENTIFIED BY 'beeruser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'beeruser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `brewery`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerlist`;
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (1, 'Russian River Brewing Co.', 'Santa Rosa', 'California', '1997', 'United States', '725 4th St.', NULL, 'https://russianriverbrewing.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (2, 'Perennial Artisan Ales', 'St. Louis', 'Missouri', '2011', 'United States', '8125 Michigan Ave.', NULL, 'http://www.perennialbeer.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (3, 'Toppling Goliath Brewing Co.', 'Decorah', 'Iowa', '2009', 'United States', '1600 Prosperity Rd.', NULL, 'https://www.tgbrews.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (4, '3 Floyds Brewing Co.', 'Munster', 'Indiana', '1996', 'United States', '9750 Indiana Pky.', NULL, 'https://www.3floyds.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (5, 'Tree House Brewing Co.', 'Charlton', 'Massachusetts', '2011', 'United States', '129 Sturbridge Rd.', NULL, 'https://www.treehousebrew.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (6, 'The Alchemist', 'Waterbury', 'Vermont', '2003', 'United States', '100 Cottage Club Rd.', NULL, 'https://alchemistbeer.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (7, 'Brouwerij 3 Fonteinen', 'Beersel', 'Flemish Brabant', '1998', 'Belgium', 'Molenstraat 47, 1651 Lot', NULL, 'https://3fonteinen.be/en/');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (8, 'Bottle Logic Brewing', 'Anaheim', 'California', '2013', 'United States', '1072 N. Armando St.', NULL, 'http://bottlelogic.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (9, 'J. Wakefield Brewing', 'Miami', 'Florida', '2005', 'United States', '120 NW 24th St', NULL, 'https://jwakefieldbrewing.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (10, 'Founders Brewing Co.', 'Grand Rapids', 'Michigan', '1997', 'United States', '235 Grandville Ave. SW', NULL, 'https://foundersbrewing.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (11, 'Side Project Brewing', 'Maplewood', 'Missouri', '2013', 'United States', '7373 Marietta Ave.', NULL, 'http://www.sideprojectbrewing.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (12, 'Santa Adairius Rustic Ales', 'Capitola', 'California', '2011', 'United States', '103 Kennedy Drive', NULL, 'http://rusticales.com');
INSERT INTO `brewery` (`id`, `name`, `city`, `state`, `year_established`, `country`, `address`, `notes`, `website`) VALUES (13, 'Hill Farmstead Brewery', 'Greensboro Bend', 'Vermont', '2010', 'United States', '403 Hill Rd.', NULL, 'https://hillfarmstead.com/');

COMMIT;


-- -----------------------------------------------------
-- Data for table `beer`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerlist`;
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (1, 'Kentucky Brunch Brand Stout', 'American Imperial Stout', 12.00, 'This beer is the real McCoy. Barrel aged and crammed with coffee, none other will stand in it’s way. Sought out for being delicious, it is notoriously difficult to track down. If you can find one, shoot to kill, because it is definitely wanted... dead or alive.', NULL, 3);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (2, 'Barrel-Aged Abraxas', 'American Imperial Stout', 11.00, 'Imperial Stout aged Twelve months in Rittenhouse Rye barrels with cacao nibs, vanilla beans, ancho chiles & cinnamon sticks', NULL, 2);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (3, 'Marshmallow Handle', 'Russian Imperial Stout', 15.00, 'Dark Lord Russian Imperial Stout aged in a variety of Bourbon barrels with vanilla beans.', NULL, 4);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (4, 'King Julius', 'New England IPA', 8.30, 'King Julius is our endeavor to marry our past with what we aspire to be in the future. King Julius is an American Double IPA brewed to be an exceptionally flavorful, juicy, and hop saturated beer while never tiring the palate. It’s vivid citrus aromas give way to flavors of orange creamsicle, mango smoothie, and a bounty of fresh tropical fruit. We find it to be supremely soft in the midst of an onslaught of flavor. . . A beer we are quite proud of.', NULL, 5);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (5, 'Heady Topper', 'New England IPA', 8.00, 'An American Double IPA. Drink from the can.', NULL, 6);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (6, 'Very Hazy', 'New England IPA', 8.60, 'A kicked up version of Haze, Very Hazy is a beer that makes us Very Happy! Very Hazy conveys all the beautiful flavors of Haze, but with even greater depth and potency. Pungent grapefruit notes greet your palate while an underlying current of soft tropical fruit dances in the background. Just the right amount of bitterness balances the sweet fruit flavors while a velvety soft mouthfeel make you easily (and dangerously!) forget this one clocks in at 8.6% ABV. A huge and beautiful beer that maintains softness and delicacy - a beer we are very excited about!', NULL, 5);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (7, 'Zenne Y Frontera', 'Belgian Lambic', 7.00, '3 Fonteinen Zenne y Frontera is the latest creation of Armand Debelder, together with sommelier Andy De Brouwer of Les Eleveurs. The lambic was aged in 40-year old casks for 12 months prior to bottling. According to the brewery, this collaboration seeks to bridge the beer and wine worlds and is also aimed at drawing in the culinary sector.', NULL, 7);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (8, 'Mornin’ Delight', 'American Imperial Stout', 12.00, 'How do you like your coffee? Try our delicious coffee stout and you\'ll never want your low-fat vanilla cream latte again. This might not contain a wonderful design in the foam, but it certainly will satisfy your need for a late evening coffee pick-me-up.', NULL, 3);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (9, 'SR-71', 'American Imperial Stout', 14.00, 'A different beer from previous draft iterations of SR-71. This beer has been confirmed to be the equivalent of Assassin (Barrel Aged Norseman’s Wrath) with more time in the barrels. The fill date mirrors the 2014 Assassin release that was aged in Pappy Van Winkle barrels and is most likely drawn from the exact same batch of base beer.', NULL, 3);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (10, 'Pliny the Younger', 'American Imperial IPA', 10.25, 'Pliny the Younger, the man, was Pliny the Elder’s nephew and adopted son. They lived nearly 2,000 years ago! Pliny the Elder is our Double IPA, so we felt it was fitting to name our Triple IPA after his son. It is almost a true Triple IPA with triple the amount of hops as a regular I.P.A. That said, it is extremely difficult, time and space consuming, and very expensive to make. And that is why we don’t make it more often! This beer is very full-bodied with tons of hop character in the nose and throughout. It is also deceptively well-balanced and smooth.', NULL, 1);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (11, 'Fundamental Observation', 'American Imperial Stout', 14.30, 'Imperial Stout blended with Madagascar Vanilla Beans & Aged in Bourbon Barrels.', NULL, 8);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (12, 'Very Green', 'New England IPA', 8.60, 'This Double IPA is created with a massive kettle charge of Australian and American hops. It opens in the glass with huge notes of ripe pineapple, pithy citrus, and dank saturated hops. As it warms it shows its depth and complexity. . . Sweet hints of malt intermingle with straight Tropicana. It has a soft but pointed bitterness and a rich, velvety mouth feel.', NULL, 5);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (13, 'Juice Machine', 'New England IPA', 8.20, 'It is essentially a marriage of the King Julius malt bill with a hopping intensity schedule similar to that of Very Green. The use of Magnum, Columbus, Amarillo, Citra, and Galaxy creates perhaps our most complex drink with unapologetic flavors of tangerine, mango, lime, papaya, and grapefruit with waves of dankness. Hop burp nirvana, indeed.', NULL, 5);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (14, 'It Was All A Dream', 'American Imperial Stout', 17.00, 'Barrel Aged Big Poppa. Imperial stout aged in bourbon maple syrup barrels with coffee, coconut and vanilla. Collaboration with Abnormal Beer Co., JPizo & Mostra Coffee.', NULL, 9);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (15, 'CBS (Canadian Breakfast Stout)', 'American Imperial Stout', 11.70, 'Canadian Breakfast Stout is an Imperial Stout brewed with a blend of coffees and imported chocolates, then aged in spent bourbon barrels that have most recently been aging pure Michigan maple syrup', NULL, 10);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (16, 'Anabasis', 'American Barleywine', 14.00, 'Anabasis is our barleywine that was brewed with American malt and hops, but fermented with a strong English Ale strain to provide rich toffees, fruity hops, with a strong leathery, caramel backbone. Bourbon, vanilla and gentle oxidation showcase the 24 months of bourbon barrel aging that Anabasis went through to reach maturity.', NULL, 11);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (17, 'Westly', 'American Wild Ale', 8.50, 'Westly is a reinterpretation of on of our favorite beers we make here at SARA, West Ashley. It is also an exercise in folly. We indulged ourselves on question: what would Ashley be like with more fruit and longer aging? Twice the amount of apricots and twice the time in barrels, Westly is the answer. We hope you agree that sometimes more is better. Sometimes folly is the path. Sante!', NULL, 12);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (18, 'Pliny The Elder', 'American Imperial IPA', 8.00, 'Pliny the Elder is brewed with Amarillo, Centennial, CTZ, and Simcoe hops. It is well-balanced with malt, hops, and alcohol, slightly bitter with a fresh hop aroma of floral, citrus, and pine. Best enjoyed FRESH! That is why we make it in such limited supply. Actual bottling date is printed on each bottle!', NULL, 1);
INSERT INTO `beer` (`id`, `name`, `type`, `abv`, `description`, `notes`, `brewery_id`) VALUES (19, 'Abner', 'New England IPA', 8.20, 'Abner (1867-1953) is our great grandfather; Hill Farmstead Brewery rests upon the land that was once home to him and his fourteen children. In his honor, this Double IPA is dutifully crafted from American malted barley, a plethora of American hops, our ale yeast and water from Abner’s well. It is unfiltered, naturally carbonated, and double dry hopped. Aromatic and flowery, bursting with notes of citrus and pine, this is the ale that I dream to have shared with Abner.', NULL, 13);

COMMIT;

