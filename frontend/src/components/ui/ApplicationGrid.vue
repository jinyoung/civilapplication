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
                <v-btn style="margin-left: 5px;" @click="submitApplicationDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Applicant')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>민원 신청서 제출
                </v-btn>
                <v-dialog v-model="submitApplicationDialog" width="500">
                    <SubmitApplication
                        @closeDialog="submitApplicationDialog = false"
                        @submitApplication="submitApplication"
                    ></SubmitApplication>
                </v-dialog>
            </div>
            <ApplicationSummary @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ApplicationSummary>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ApplicantId</th>
                        <th>MinwonType</th>
                        <th>ApplicationReason</th>
                        <th>IssuedNumber</th>
                        <th>userId</th>
                        <th>File</th>
                        <th>사용자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="ApplicantId">{{ val.applicantId }}</td>
                            <td class="whitespace-nowrap" label="MinwonType">{{ val.minwonType }}</td>
                            <td class="whitespace-nowrap" label="ApplicationReason">{{ val.applicationReason }}</td>
                            <td class="whitespace-nowrap" label="IssuedNumber">{{ val.issuedNumber }}</td>
                            <td class="whitespace-nowrap" label="사용자">
                                <UserId :editMode="editMode" v-model="val.userId"></UserId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Application 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Application :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Application 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="ApplicationId" v-model="selectedRow.applicationId" :editMode="true"/>
                            <String label="ApplicantId" v-model="selectedRow.applicantId" :editMode="true"/>
                            <String label="MinwonType" v-model="selectedRow.minwonType" :editMode="true"/>
                            <String label="ApplicationReason" v-model="selectedRow.applicationReason" :editMode="true"/>
                            <String label="IssuedNumber" v-model="selectedRow.issuedNumber" :editMode="true"/>
                            <UserId offline label="userId" v-model="selectedRow.userId" :editMode="true"/>
                            <File offline label="File" v-model="selectedRow.file" :editMode="true"/>
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
    name: 'applicationGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'applications',
        submitApplicationDialog: false,
    }),
    watch: {
    },
    methods:{
        submitApplication(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "submitApplication", params)
                this.$EventBus.$emit('show-success','SubmitApplication 성공적으로 처리되었습니다.')
                this.submitApplicationDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>