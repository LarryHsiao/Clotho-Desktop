package com.silverhetch.clotho.desktop.event.draging

import javafx.event.EventHandler
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.input.DragEvent

class ListDragging<T>(
    private val cell: ListCell<T>,
    private val listView: ListView<T>
) : EventHandler<DragEvent> {
    override fun handle(it: DragEvent?) {
        it?.let {
            listView.selectionModel.clearSelection()
            listView.selectionModel.select(cell.item)
            it.consume()
        }
    }
}