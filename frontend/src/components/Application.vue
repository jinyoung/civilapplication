<template>
    <div>
        <String label="ApplicationId" v-model="value.applicationId" :editMode="editMode"/>
        <String label="ApplicantId" v-model="value.applicantId" :editMode="editMode"/>
        <String label="MinwonType" v-model="value.minwonType" :editMode="editMode"/>
        <String label="ApplicationReason" v-model="value.applicationReason" :editMode="editMode"/>
        <String label="IssuedNumber" v-model="value.issuedNumber" :editMode="editMode"/>
        <UserId offline label="userId" v-model="value.userId" :editMode="editMode" @change="change"/>
        <File offline label="File" v-model="value.file" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Application',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "applications"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
