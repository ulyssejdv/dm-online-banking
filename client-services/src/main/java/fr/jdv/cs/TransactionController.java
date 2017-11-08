package fr.jdv.cs;

import fr.ekinci.clientmodels.HistoryDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ulysse on 06/11/2017.
 */
@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

    @PostMapping
    public void doTransaction(@RequestBody HistoryDto historyDto) {

    }

}
