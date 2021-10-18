package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CharacterDnd;
import com.revature.models.CharacterSheet;
import com.revature.models.charactersheet.Spell;
import com.revature.service.CharacterDndService;
import com.revature.service.SpellService;

@RestController("spellController")
@RequestMapping("/spell")
public class SpellController {

	@Autowired
	private CharacterDndService characterDndService;

	@Autowired
	private SpellService spellService;

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CharacterSheet> createSpell(@RequestBody Spell spell, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));
			if (character != null) {
				character.getCharacterSheet().getSpellSheet().getSpells().add(spell);
				spell.setSpellSheet(character.getCharacterSheet().getSpellSheet());
				this.spellService.save(spell);
				return new ResponseEntity<CharacterSheet>(character.getCharacterSheet(), HttpStatus.OK);
			} else {
				// TODO: No character selected
				return new ResponseEntity<CharacterSheet>(HttpStatus.BAD_REQUEST);
			}
		}

		else {
			return new ResponseEntity<CharacterSheet>(HttpStatus.METHOD_NOT_ALLOWED);
		}
	}

	@PostMapping(path = "/update")
	public Spell updateSpell(@RequestBody Spell spell, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));
			if (character != null) {
				// Update spell with parameter values
				character.getCharacterSheet().getSpellSheet().getSpells();
				spell.setSpellSheet(character.getCharacterSheet().getSpellSheet());

				return this.spellService.save(spell);
			} else {
				// TODO: No character selected
				return null;
			}

		}

		else {

			return null;
		}
	}

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Spell> getAll(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));
			int id = character.getCharacterSheet().getSpellSheet().getSpellSheetId();
			return spellService.getAll(id);
		} else {
			// TODO: No session
			return null;
		}

	}

	@PostMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteSpell(@RequestBody Spell spell, HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));
			if (character != null) {
				Spell spellDelete = spellService.findByName(spell.getName());
				List<Spell> spells = character.getCharacterSheet().getSpellSheet().getSpells();
				spells.remove(spellDelete);
				character.getCharacterSheet().getSpellSheet().setSpells(spells);
				spellService.delete(spellDelete);
			} else {
				// TODO: No character selected
			}
		} else {
			// TODO: No session
		}
	}

	@GetMapping(path = "/all", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void getAllSpells(@RequestParam String name, HttpServletRequest request) {

	}
}