package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CharacterDnd;
import com.revature.models.CharacterSheet;
import com.revature.models.charactersheet.AbilitySheet;
import com.revature.models.charactersheet.ActionSheet;
import com.revature.models.charactersheet.FeatureSheet;
import com.revature.models.charactersheet.InventorySheet;
import com.revature.models.charactersheet.MoneySheet;
import com.revature.models.charactersheet.ProficiencySheet;
import com.revature.models.charactersheet.SkillSheet;
import com.revature.models.charactersheet.SpellSheet;
import com.revature.models.charactersheet.TraitSheet;
import com.revature.models.charactersheet.VitalsSheet;
import com.revature.service.CharacterDndService;
import com.revature.service.CharacterSheetService;

@RestController("CharacterSheetController")

@RequestMapping("/character/sheet")
public class CharacterSheetController {

	@Autowired
	private CharacterDndService characterDndService;

	private CharacterSheetService characterSheetService;

	@Autowired
	public CharacterSheetController(CharacterSheetService characterSheetService) {
		this.characterSheetService = characterSheetService;
	}

	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CharacterSheet> createCharacterSheet(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {

			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));

			if (character.getCharacterSheet() == null) {

				// create all sheets for character
				CharacterSheet characterSheet = new CharacterSheet();
				AbilitySheet abilitySheet = new AbilitySheet();
				ActionSheet actionSheet = new ActionSheet();
				FeatureSheet featureSheet = new FeatureSheet();
				InventorySheet inventorySheet = new InventorySheet();
				MoneySheet moneySheet = new MoneySheet();
				ProficiencySheet proficiencySheet = new ProficiencySheet();
				SkillSheet skillSheet = new SkillSheet();
				SpellSheet spellSheet = new SpellSheet();
				TraitSheet traitSheet = new TraitSheet();
				VitalsSheet vitalsSheet = new VitalsSheet();

				// bidirectional relationship so have to set both sides.
				abilitySheet.setCharacterSheet(characterSheet);
				actionSheet.setCharacterSheet(characterSheet);
				featureSheet.setCharacterSheet(characterSheet);
				inventorySheet.setCharacterSheet(characterSheet);
				moneySheet.setCharacterSheet(characterSheet);
				proficiencySheet.setCharacterSheet(characterSheet);
				skillSheet.setCharacterSheet(characterSheet);
				spellSheet.setCharacterSheet(characterSheet);
				traitSheet.setCharacterSheet(characterSheet);
				vitalsSheet.setCharacterSheet(characterSheet);
				characterSheet.setAbilitySheet(abilitySheet);
				characterSheet.setAbilitySheet(abilitySheet);
				characterSheet.setActionSheet(actionSheet);
				characterSheet.setFeatureSheet(featureSheet);
				characterSheet.setInventorySheet(inventorySheet);
				characterSheet.setMoneySheet(moneySheet);
				characterSheet.setProficiencySheet(proficiencySheet);
				characterSheet.setSkillSheet(skillSheet);
				characterSheet.setSpellSheet(spellSheet);
				characterSheet.setTraitSheet(traitSheet);
				characterSheet.setVitalsSheet(vitalsSheet);
				character.setCharacterSheet(characterSheet);
				session.setAttribute("characterSheetId", characterSheet.getCharacterSheetId());
				
				
				// Set name and campaign
				characterSheet.setName(character.getName());
				characterSheet.setCampaign(character.getCampaign().getName());

				characterSheet.setCharacter(character);
				return new ResponseEntity<CharacterSheet>(this.characterSheetService.save(characterSheet),
						HttpStatus.OK);
			}

			else {
				// TODO: Character already has sheet send it as JSON
				return new ResponseEntity<CharacterSheet>(character.getCharacterSheet(), HttpStatus.OK);
			}
		} else {
			// TODO: No session.
			return new ResponseEntity<CharacterSheet>(HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CharacterSheet> updateCharacterSheet(CharacterSheet characterSheet,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {

			// TODO: Exception for get when characterId attribute is null
			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));

			if (character.getCharacterSheet() != null) {

				//character.setCharacterSheet(characterSheet);
				characterSheet.setCharacter(character);
				return new ResponseEntity<CharacterSheet>(this.characterSheetService.save(characterSheet),
						HttpStatus.OK);
			}

			else {
				// TODO: No character sheet exist(should not happen if "/" endpoint is used
				// OnLoad()
				return new ResponseEntity<CharacterSheet>(HttpStatus.NOT_FOUND);
			}
		} else {
			// TODO: No session.
			return new ResponseEntity<CharacterSheet>(HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<List<CharacterSheet>> findAll() {
	 * 
	 * return new
	 * ResponseEntity<List<CharacterSheet>>(this.characterSheetService.findAll(),
	 * HttpStatus.OK); }
	 * 
	 * 
	 * @GetMapping(path = "/name/{name}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public CharacterSheet
	 * findByName(@PathVariable String name) { return
	 * this.characterSheetService.findByName(name); }
	 * 
	 * @PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public void saveRecipe(@RequestBody CharacterSheet characterSheet) {
	 * this.characterSheetService.save(characterSheet); }
	 * 
	 * @GetMapping(path = "/exception") public void throwException() { throw new
	 * RuntimeException(); }
	 * 
	 * @GetMapping(path = "/exception-handling") public void
	 * throwBusinessException() { throw new BusinessException(); }
	 */
}
