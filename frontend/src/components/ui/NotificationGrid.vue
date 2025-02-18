<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="sendNotificationDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>알림 전송
                </v-btn>
                <v-dialog v-model="sendNotificationDialog" width="500">
                    <SendNotification
                        @closeDialog="sendNotificationDialog = false"
                        @sendNotification="sendNotification"
                    ></SendNotification>
                </v-dialog>
            </div>
            <NotificationSummary @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></NotificationSummary>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ApplicationNumber</th>
                        <th>SentDate</th>
                        <th>applicationId</th>
                        <th>Recipient</th>
                        <th>NotificationMethod</th>
                        <th>Status</th>
                        <th>민원신청</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="ApplicationNumber">{{ val.applicationNumber }}</td>
                            <td class="whitespace-nowrap" label="SentDate">{{ val.sentDate }}</td>
                            <td class="whitespace-nowrap" label="Recipient">{{ val.recipient }}</td>
                            <td class="whitespace-nowrap" label="NotificationMethod">{{ val.notificationMethod }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="민원신청">
                                <ApplicationId :editMode="editMode" v-model="val.applicationId"></ApplicationId>
                            </td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Notification 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Notification :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Notification 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="NotificationId" v-model="selectedRow.notificationId" :editMode="true"/>
                            <String label="ApplicationNumber" v-model="selectedRow.applicationNumber" :editMode="true"/>
                            <Date label="SentDate" v-model="selectedRow.sentDate" :editMode="true"/>
                            <String label="Recipient" v-model="selectedRow.recipient" :editMode="true"/>
                            <String label="NotificationMethod" v-model="selectedRow.notificationMethod" :editMode="true"/>
                            <ApplicationId offline label="applicationId" v-model="selectedRow.applicationId" :editMode="true"/>
                            <Status offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'notificationGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'notifications',
        sendNotificationDialog: false,
    }),
    watch: {
    },
    methods:{
        sendNotification(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "sendNotification", params)
                this.$EventBus.$emit('show-success','SendNotification 성공적으로 처리되었습니다.')
                this.sendNotificationDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>