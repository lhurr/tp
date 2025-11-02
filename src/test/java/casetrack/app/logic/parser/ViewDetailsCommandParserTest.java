package casetrack.app.logic.parser;

import static casetrack.app.logic.parser.CommandParserTestUtil.assertParseFailure;
import static casetrack.app.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static casetrack.app.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static casetrack.app.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import casetrack.app.logic.commands.ViewDetailsCommand;

public class ViewDetailsCommandParserTest {

    private ViewDetailsCommandParser parser = new ViewDetailsCommandParser();

    @Test
    public void parse_validPatientArgs_returnsViewDetailsCommand() {
        assertParseSuccess(parser, "1", new ViewDetailsCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_patientWithInvalidFormat_throwsParseException() {
        assertParseFailure(parser, "-1", MESSAGE_INVALID_INDEX);
    }

    @Test
    public void parse_emptyArgs_throwsParseException() {
        assertParseFailure(parser, "", MESSAGE_INVALID_INDEX);
    }
}
