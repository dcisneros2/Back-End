package com.revature.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CharacterDnd;
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

	@PostMapping(path = "/create")
	public Spell createSpell(@RequestParam Map<String, String> queryParams, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));
			if (character != null) {
				// Create spell with parameter values
				Spell spell = new Spell();
				spell.setName(queryParams.get("name"));
				//spell.setDescription(queryParams.get("description"));
				spell.setLevel(Integer.valueOf(queryParams.get("quantity")));

				character.getCharacterSheet().getSpellSheet().getSpells().add(spell);
				// spell.setSpellSheet(character.getspellSheet());

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

	@PostMapping(path = "/update")
	public Spell updateSpell(@RequestParam Map<String, String> queryParams, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));
			if (character != null) {
				// Update spell with parameter values

				Spell spell = spellService.getById(Integer.valueOf(queryParams.get("spellId")));

				// List<Spell> spells =
				// character.getCharacterSheet().getInventorySheet().getSpells();
				spell.setName(queryParams.get("name"));
				spell.setLevel(Integer.valueOf(queryParams.get("level")));
				//spell.setDescription(queryParams.get("description"));

				// character.getCharacterSheet().getInventorySheet().getSpells().contains(spell);

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
			int id = character.getCharacterSheet().getInventorySheet().getInventorySheetId();
			return spellService.getAll(id);
		} else {
			// TODO: No session
			return null;
		}

	}

	@PostMapping(path = "/delete")
	public void deleteSpell(@RequestParam String name, HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			CharacterDnd character = characterDndService.getById((Integer) session.getAttribute("characterId"));
			if (character != null) {
				Spell spell = spellService.findByName(name);
				List<Spell> spells = character.getCharacterSheet().getSpellSheet().getSpells();
				spells.remove(spell);
				character.getCharacterSheet().getSpellSheet().setSpells(spells);
				spellService.delete(spell);

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