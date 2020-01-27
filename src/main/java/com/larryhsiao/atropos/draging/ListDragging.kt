package com.larryhsiao.atropos.draging

import javafx.event.EventHandler
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.input.DragEvent
import javafx.scene.input.DragEvent.DRAG_ENTERED

class ListDragging<T>(
    private val cell: ListCell<T>,
    private val listView: ListView<T>
) : EventHandler<DragEvent> {
    override fun handle(it: DragEvent) {
        when (it.eventType) {
            DRAG_ENTERED -> {
                listView.selectionModel.clearSelection()
                listView.selectionModel.select(cell.item)
                it.consume()
            }
        }
    }
}